package core

import lib.{Datatype, Primitives, Type, Kind, UrlKey}
import com.gilt.apidoc.spec.v0.models._
import play.api.libs.json._

object ServiceBuilder {

  def apply(
    config: ServiceConfiguration,
    apiJson: String
  ): Service = {
    val jsValue = Json.parse(apiJson)
    apply(config, InternalServiceForm(jsValue))
  }

  def apply(
    config: ServiceConfiguration,
    internal: InternalServiceForm
  ): Service = {
    val resolver = TypeResolver(
      RecursiveTypesProvider(internal)
    )

    val name = internal.name.getOrElse(sys.error("Missing name"))
    val key = internal.key.getOrElse { UrlKey.generate(name) }
    val namespace = internal.namespace.getOrElse { config.applicationNamespace(key) }
    val imports = internal.imports.map { ImportBuilder(_) }.sortWith(_.uri.toLowerCase < _.uri.toLowerCase)
    val headers = internal.headers.map { HeaderBuilder(resolver, _) }
    val enums = internal.enums.map { EnumBuilder(_) }.sortWith(_.name.toLowerCase < _.name.toLowerCase)
    val unions = internal.unions.map { UnionBuilder(_) }.sortWith(_.name.toLowerCase < _.name.toLowerCase)
    val models = internal.models.map { ModelBuilder(resolver, _) }.sortWith(_.name.toLowerCase < _.name.toLowerCase)
    val resources = internal.resources.map { ResourceBuilder(resolver, models, _) }.sortWith(_.`type`.toLowerCase < _.`type`.toLowerCase)

    Service(
      name = name,
      namespace = namespace,
      organization = Organization(key = config.orgKey),
      application = Application(key = key),
      version = config.version,
      imports = imports,
      description = internal.description,
      baseUrl = internal.baseUrl,
      enums = enums,
      unions = unions,
      models = models,
      headers = headers,
      resources = resources
    )
  }
}

object ResourceBuilder {

  def apply(
    resolver: TypeResolver,
    models: Seq[Model],
    internal: InternalResourceForm
  ): Resource = {
    Resource(
      `type` = internal.datatype.name,
      description = internal.description,
      operations = internal.operations.map(op => OperationBuilder(resolver, op, models.find(_.name == internal.datatype.name)))
    )
  }

}

object OperationBuilder {

  def apply(resolver: TypeResolver, internal: InternalOperationForm, model: Option[Model]): Operation = {
    val method = internal.method.getOrElse { sys.error("Missing method") }
    val location = if (!internal.body.isEmpty || method == "GET") { ParameterLocation.Query } else { ParameterLocation.Form }

    val pathParameters = internal.namedPathParameters.map { name =>
      internal.parameters.find(_.name == Some(name)) match {
        case None => {
          ParameterBuilder.fromPath(name, model)
        }
        case Some(declared) => {
          // Path parameter was declared in the parameters
          // section. Use the explicit information provided in the
          // specification
          ParameterBuilder(resolver, declared, ParameterLocation.Path)
        }
      }
    }

    val internalParams = internal.parameters.filter(p => pathParameters.find(_.name == p.name.get).isEmpty).map { p =>
      ParameterBuilder(resolver, p, location)
    }

    Operation(
      method = Method(method),
      path = internal.path,
      description = internal.description,
      body = internal.body.map { ib => BodyBuilder(resolver, ib) },
      parameters = pathParameters ++ internalParams,
      responses = internal.responses.map { ResponseBuilder(resolver, _) }
    )
  }

}

object BodyBuilder {

  def apply(resolver: TypeResolver, ib: InternalBodyForm): Body = {
    ib.datatype match {
      case None => sys.error("Body missing type: " + ib)
      case Some(datatype) => Body(
        `type` = resolver.parseWithError(datatype).label,
        description = ib.description
      )
    }
  }

}


object EnumBuilder {

  def apply(ie: InternalEnumForm): Enum = {
    Enum(
      name = ie.name,
      description = ie.description,
      values = ie.values.map { iv => EnumValue(name = iv.name.get, description = iv.description) }
    )
  }

}

object UnionBuilder {

  def apply(internal: InternalUnionForm): Union = {
    Union(
      name = internal.name,
      description = internal.description,
      types = internal.types.map { it => UnionType(`type` = it.datatype.get.label, description = it.description) }
    )
  }

}

object HeaderBuilder {

  def apply(resolver: TypeResolver, ih: InternalHeaderForm): Header = {
    Header(
      name = ih.name.get,
      `type` = resolver.parseWithError(ih.datatype.get).label,
      required = ih.required,
      description = ih.description,
      default = ih.default
    )
  }

}

object ImportBuilder {

  def apply(internal: InternalImportForm): Import = {
    val importer = Importer(internal.uri.get)
    val service = importer.service

    Import(
      uri = internal.uri.get,
      organization = service.organization,
      application = service.application,
      namespace = service.namespace,
      version = service.version,
      enums = service.enums.map(_.name),
      unions = service.unions.map(_.name),
      models = service.models.map(_.name)
    )
  }

}

object ModelBuilder {

  def apply(resolver: TypeResolver, im: InternalModelForm): Model = {
    Model(
      name = im.name,
      plural = im.plural,
      description = im.description,
      fields = im.fields.map { FieldBuilder(resolver, _) }
    )
  }

}

object ResponseBuilder {

  def apply(resolver: TypeResolver, internal: InternalResponseForm): Response = {
    Response(
      code = internal.code.toInt,
      `type` = resolver.parseWithError(internal.datatype.get).label
    )
  }

}

object ParameterBuilder {

  def fromPath(name: String, model: Option[Model]): Parameter = {
    val datatypeLabel: String = model.flatMap(_.fields.find(_.name == name).map(_.`type`)).getOrElse {
      Datatype.Singleton(Type(Kind.Primitive, Primitives.String.toString)).label
    }

    Parameter(
      name = name,
      `type` = datatypeLabel,
      location = ParameterLocation.Path,
      required = true
    )
  }

  def apply(resolver: TypeResolver, internal: InternalParameterForm, location: ParameterLocation): Parameter = {
    val typeInstance = resolver.parseWithError(internal.datatype.get)

    internal.default.map { resolver.assertValidDefault(typeInstance, _) }

    Parameter(
      name = internal.name.get,
      `type` = typeInstance.label,
      location = location,
      description = internal.description,
      required = internal.required,
      default = internal.default,
      minimum = internal.minimum,
      maximum = internal.maximum,
      example = internal.example
    )
  }

}

object FieldBuilder {

  def apply(
    resolver: TypeResolver,
    internal: InternalFieldForm
  ): Field = {
    val datatype = resolver.parseWithError(internal.datatype.get)

    internal.default.map { resolver.assertValidDefault(datatype, _) }

    Field(
      name = internal.name.get,
      `type` = datatype.label,
      description = internal.description,
      required = internal.required,
      default = internal.default,
      minimum = internal.minimum,
      maximum = internal.maximum,
      example = internal.example
    )
  }

}
