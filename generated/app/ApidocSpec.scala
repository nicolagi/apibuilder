/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.8.18
 * apidoc:0.8.18 http://localhost:9000/gilt/apidoc-spec/0.8.18/play_2_3_client
 */
package com.gilt.apidoc.spec.v0.models {

  case class Application(
    key: String
  )

  case class Body(
    `type`: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None
  )

  /**
   * Indicates that this particular element is considered deprecated in the API. See
   * the description for details
   */
  case class Deprecation(
    description: _root_.scala.Option[String] = None
  )

  case class Enum(
    name: String,
    plural: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    values: Seq[com.gilt.apidoc.spec.v0.models.EnumValue]
  )

  case class EnumValue(
    name: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None
  )

  case class Field(
    name: String,
    `type`: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    default: _root_.scala.Option[String] = None,
    required: Boolean,
    minimum: _root_.scala.Option[Long] = None,
    maximum: _root_.scala.Option[Long] = None,
    example: _root_.scala.Option[String] = None
  )

  case class Header(
    name: String,
    `type`: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    required: Boolean,
    default: _root_.scala.Option[String] = None
  )

  /**
   * An import is used to declare a dependency on another application. This allows
   * you to reference the models and or enums from that application in your own app.
   */
  case class Import(
    uri: String,
    namespace: String,
    organization: com.gilt.apidoc.spec.v0.models.Organization,
    application: com.gilt.apidoc.spec.v0.models.Application,
    version: String,
    enums: Seq[String],
    unions: Seq[String],
    models: Seq[String]
  )

  case class Model(
    name: String,
    plural: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    fields: Seq[com.gilt.apidoc.spec.v0.models.Field]
  )

  case class Operation(
    method: com.gilt.apidoc.spec.v0.models.Method,
    path: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    body: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Body] = None,
    parameters: Seq[com.gilt.apidoc.spec.v0.models.Parameter] = Nil,
    responses: Seq[com.gilt.apidoc.spec.v0.models.Response] = Nil
  )

  case class Organization(
    key: String
  )

  case class Parameter(
    name: String,
    `type`: String,
    location: com.gilt.apidoc.spec.v0.models.ParameterLocation,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    required: Boolean,
    default: _root_.scala.Option[String] = None,
    minimum: _root_.scala.Option[Long] = None,
    maximum: _root_.scala.Option[Long] = None,
    example: _root_.scala.Option[String] = None
  )

  case class Resource(
    `type`: String,
    plural: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    operations: Seq[com.gilt.apidoc.spec.v0.models.Operation]
  )

  case class Response(
    code: Int,
    `type`: String,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None
  )

  case class Service(
    name: String,
    organization: com.gilt.apidoc.spec.v0.models.Organization,
    application: com.gilt.apidoc.spec.v0.models.Application,
    namespace: String,
    version: String,
    baseUrl: _root_.scala.Option[String] = None,
    description: _root_.scala.Option[String] = None,
    headers: Seq[com.gilt.apidoc.spec.v0.models.Header],
    imports: Seq[com.gilt.apidoc.spec.v0.models.Import],
    enums: Seq[com.gilt.apidoc.spec.v0.models.Enum],
    unions: Seq[com.gilt.apidoc.spec.v0.models.Union],
    models: Seq[com.gilt.apidoc.spec.v0.models.Model],
    resources: Seq[com.gilt.apidoc.spec.v0.models.Resource]
  )

  case class Union(
    name: String,
    plural: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None,
    types: Seq[com.gilt.apidoc.spec.v0.models.UnionType]
  )

  /**
   * Metadata about one of the types that is part of a union type
   */
  case class UnionType(
    `type`: String,
    description: _root_.scala.Option[String] = None,
    deprecation: _root_.scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation] = None
  )

  sealed trait Method

  object Method {

    case object Get extends Method { override def toString = "GET" }
    case object Post extends Method { override def toString = "POST" }
    case object Put extends Method { override def toString = "PUT" }
    case object Patch extends Method { override def toString = "PATCH" }
    case object Delete extends Method { override def toString = "DELETE" }
    case object Head extends Method { override def toString = "HEAD" }
    case object Connect extends Method { override def toString = "CONNECT" }
    case object Options extends Method { override def toString = "OPTIONS" }
    case object Trace extends Method { override def toString = "TRACE" }

    /**
     * UNDEFINED captures values that are sent either in error or
     * that were added by the server after this library was
     * generated. We want to make it easy and obvious for users of
     * this library to handle this case gracefully.
     *
     * We use all CAPS for the variable name to avoid collisions
     * with the camel cased values above.
     */
    case class UNDEFINED(override val toString: String) extends Method

    /**
     * all returns a list of all the valid, known values. We use
     * lower case to avoid collisions with the camel cased values
     * above.
     */
    val all = Seq(Get, Post, Put, Patch, Delete, Head, Connect, Options, Trace)

    private[this]
    val byName = all.map(x => x.toString -> x).toMap

    def apply(value: String): Method = fromString(value).getOrElse(UNDEFINED(value))

    def fromString(value: String): _root_.scala.Option[Method] = byName.get(value)

  }

  sealed trait ParameterLocation

  object ParameterLocation {

    case object Path extends ParameterLocation { override def toString = "Path" }
    case object Query extends ParameterLocation { override def toString = "Query" }
    case object Form extends ParameterLocation { override def toString = "Form" }

    /**
     * UNDEFINED captures values that are sent either in error or
     * that were added by the server after this library was
     * generated. We want to make it easy and obvious for users of
     * this library to handle this case gracefully.
     *
     * We use all CAPS for the variable name to avoid collisions
     * with the camel cased values above.
     */
    case class UNDEFINED(override val toString: String) extends ParameterLocation

    /**
     * all returns a list of all the valid, known values. We use
     * lower case to avoid collisions with the camel cased values
     * above.
     */
    val all = Seq(Path, Query, Form)

    private[this]
    val byName = all.map(x => x.toString -> x).toMap

    def apply(value: String): ParameterLocation = fromString(value).getOrElse(UNDEFINED(value))

    def fromString(value: String): _root_.scala.Option[ParameterLocation] = byName.get(value)

  }

}

package com.gilt.apidoc.spec.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import com.gilt.apidoc.spec.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    implicit val jsonReadsApidocspecMethod = __.read[String].map(Method.apply)
    implicit val jsonWritesApidocspecMethod = new Writes[Method] {
      def writes(x: Method) = JsString(x.toString)
    }

    implicit val jsonReadsApidocspecParameterLocation = __.read[String].map(ParameterLocation.apply)
    implicit val jsonWritesApidocspecParameterLocation = new Writes[ParameterLocation] {
      def writes(x: ParameterLocation) = JsString(x.toString)
    }

    implicit def jsonReadsApidocspecApplication: play.api.libs.json.Reads[Application] = {
      (__ \ "key").read[String].map { x => new Application(key = x) }
    }

    implicit def jsonWritesApidocspecApplication: play.api.libs.json.Writes[Application] = new play.api.libs.json.Writes[Application] {
      def writes(x: Application) = play.api.libs.json.Json.obj(
        "key" -> play.api.libs.json.Json.toJson(x.key)
      )
    }

    implicit def jsonReadsApidocspecBody: play.api.libs.json.Reads[Body] = {
      (
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation]
      )(Body.apply _)
    }

    implicit def jsonWritesApidocspecBody: play.api.libs.json.Writes[Body] = {
      (
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]]
      )(unlift(Body.unapply _))
    }

    implicit def jsonReadsApidocspecDeprecation: play.api.libs.json.Reads[Deprecation] = {
      (__ \ "description").readNullable[String].map { x => new Deprecation(description = x) }
    }

    implicit def jsonWritesApidocspecDeprecation: play.api.libs.json.Writes[Deprecation] = new play.api.libs.json.Writes[Deprecation] {
      def writes(x: Deprecation) = play.api.libs.json.Json.obj(
        "description" -> play.api.libs.json.Json.toJson(x.description)
      )
    }

    implicit def jsonReadsApidocspecEnum: play.api.libs.json.Reads[Enum] = {
      (
        (__ \ "name").read[String] and
        (__ \ "plural").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "values").readNullable[Seq[com.gilt.apidoc.spec.v0.models.EnumValue]].map(_.getOrElse(Nil))
      )(Enum.apply _)
    }

    implicit def jsonWritesApidocspecEnum: play.api.libs.json.Writes[Enum] = {
      (
        (__ \ "name").write[String] and
        (__ \ "plural").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "values").write[Seq[com.gilt.apidoc.spec.v0.models.EnumValue]]
      )(unlift(Enum.unapply _))
    }

    implicit def jsonReadsApidocspecEnumValue: play.api.libs.json.Reads[EnumValue] = {
      (
        (__ \ "name").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation]
      )(EnumValue.apply _)
    }

    implicit def jsonWritesApidocspecEnumValue: play.api.libs.json.Writes[EnumValue] = {
      (
        (__ \ "name").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]]
      )(unlift(EnumValue.unapply _))
    }

    implicit def jsonReadsApidocspecField: play.api.libs.json.Reads[Field] = {
      (
        (__ \ "name").read[String] and
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "default").readNullable[String] and
        (__ \ "required").read[Boolean] and
        (__ \ "minimum").readNullable[Long] and
        (__ \ "maximum").readNullable[Long] and
        (__ \ "example").readNullable[String]
      )(Field.apply _)
    }

    implicit def jsonWritesApidocspecField: play.api.libs.json.Writes[Field] = {
      (
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "default").write[scala.Option[String]] and
        (__ \ "required").write[Boolean] and
        (__ \ "minimum").write[scala.Option[Long]] and
        (__ \ "maximum").write[scala.Option[Long]] and
        (__ \ "example").write[scala.Option[String]]
      )(unlift(Field.unapply _))
    }

    implicit def jsonReadsApidocspecHeader: play.api.libs.json.Reads[Header] = {
      (
        (__ \ "name").read[String] and
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "required").read[Boolean] and
        (__ \ "default").readNullable[String]
      )(Header.apply _)
    }

    implicit def jsonWritesApidocspecHeader: play.api.libs.json.Writes[Header] = {
      (
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "required").write[Boolean] and
        (__ \ "default").write[scala.Option[String]]
      )(unlift(Header.unapply _))
    }

    implicit def jsonReadsApidocspecImport: play.api.libs.json.Reads[Import] = {
      (
        (__ \ "uri").read[String] and
        (__ \ "namespace").read[String] and
        (__ \ "organization").read[com.gilt.apidoc.spec.v0.models.Organization] and
        (__ \ "application").read[com.gilt.apidoc.spec.v0.models.Application] and
        (__ \ "version").read[String] and
        (__ \ "enums").readNullable[Seq[String]].map(_.getOrElse(Nil)) and
        (__ \ "unions").readNullable[Seq[String]].map(_.getOrElse(Nil)) and
        (__ \ "models").readNullable[Seq[String]].map(_.getOrElse(Nil))
      )(Import.apply _)
    }

    implicit def jsonWritesApidocspecImport: play.api.libs.json.Writes[Import] = {
      (
        (__ \ "uri").write[String] and
        (__ \ "namespace").write[String] and
        (__ \ "organization").write[com.gilt.apidoc.spec.v0.models.Organization] and
        (__ \ "application").write[com.gilt.apidoc.spec.v0.models.Application] and
        (__ \ "version").write[String] and
        (__ \ "enums").write[Seq[String]] and
        (__ \ "unions").write[Seq[String]] and
        (__ \ "models").write[Seq[String]]
      )(unlift(Import.unapply _))
    }

    implicit def jsonReadsApidocspecModel: play.api.libs.json.Reads[Model] = {
      (
        (__ \ "name").read[String] and
        (__ \ "plural").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "fields").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Field]].map(_.getOrElse(Nil))
      )(Model.apply _)
    }

    implicit def jsonWritesApidocspecModel: play.api.libs.json.Writes[Model] = {
      (
        (__ \ "name").write[String] and
        (__ \ "plural").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "fields").write[Seq[com.gilt.apidoc.spec.v0.models.Field]]
      )(unlift(Model.unapply _))
    }

    implicit def jsonReadsApidocspecOperation: play.api.libs.json.Reads[Operation] = {
      (
        (__ \ "method").read[com.gilt.apidoc.spec.v0.models.Method] and
        (__ \ "path").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "body").readNullable[com.gilt.apidoc.spec.v0.models.Body] and
        (__ \ "parameters").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Parameter]].map(_.getOrElse(Nil)) and
        (__ \ "responses").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Response]].map(_.getOrElse(Nil))
      )(Operation.apply _)
    }

    implicit def jsonWritesApidocspecOperation: play.api.libs.json.Writes[Operation] = {
      (
        (__ \ "method").write[com.gilt.apidoc.spec.v0.models.Method] and
        (__ \ "path").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "body").write[scala.Option[com.gilt.apidoc.spec.v0.models.Body]] and
        (__ \ "parameters").write[Seq[com.gilt.apidoc.spec.v0.models.Parameter]] and
        (__ \ "responses").write[Seq[com.gilt.apidoc.spec.v0.models.Response]]
      )(unlift(Operation.unapply _))
    }

    implicit def jsonReadsApidocspecOrganization: play.api.libs.json.Reads[Organization] = {
      (__ \ "key").read[String].map { x => new Organization(key = x) }
    }

    implicit def jsonWritesApidocspecOrganization: play.api.libs.json.Writes[Organization] = new play.api.libs.json.Writes[Organization] {
      def writes(x: Organization) = play.api.libs.json.Json.obj(
        "key" -> play.api.libs.json.Json.toJson(x.key)
      )
    }

    implicit def jsonReadsApidocspecParameter: play.api.libs.json.Reads[Parameter] = {
      (
        (__ \ "name").read[String] and
        (__ \ "type").read[String] and
        (__ \ "location").read[com.gilt.apidoc.spec.v0.models.ParameterLocation] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "required").read[Boolean] and
        (__ \ "default").readNullable[String] and
        (__ \ "minimum").readNullable[Long] and
        (__ \ "maximum").readNullable[Long] and
        (__ \ "example").readNullable[String]
      )(Parameter.apply _)
    }

    implicit def jsonWritesApidocspecParameter: play.api.libs.json.Writes[Parameter] = {
      (
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "location").write[com.gilt.apidoc.spec.v0.models.ParameterLocation] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "required").write[Boolean] and
        (__ \ "default").write[scala.Option[String]] and
        (__ \ "minimum").write[scala.Option[Long]] and
        (__ \ "maximum").write[scala.Option[Long]] and
        (__ \ "example").write[scala.Option[String]]
      )(unlift(Parameter.unapply _))
    }

    implicit def jsonReadsApidocspecResource: play.api.libs.json.Reads[Resource] = {
      (
        (__ \ "type").read[String] and
        (__ \ "plural").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "operations").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Operation]].map(_.getOrElse(Nil))
      )(Resource.apply _)
    }

    implicit def jsonWritesApidocspecResource: play.api.libs.json.Writes[Resource] = {
      (
        (__ \ "type").write[String] and
        (__ \ "plural").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "operations").write[Seq[com.gilt.apidoc.spec.v0.models.Operation]]
      )(unlift(Resource.unapply _))
    }

    implicit def jsonReadsApidocspecResponse: play.api.libs.json.Reads[Response] = {
      (
        (__ \ "code").read[Int] and
        (__ \ "type").read[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation]
      )(Response.apply _)
    }

    implicit def jsonWritesApidocspecResponse: play.api.libs.json.Writes[Response] = {
      (
        (__ \ "code").write[Int] and
        (__ \ "type").write[String] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]]
      )(unlift(Response.unapply _))
    }

    implicit def jsonReadsApidocspecService: play.api.libs.json.Reads[Service] = {
      (
        (__ \ "name").read[String] and
        (__ \ "organization").read[com.gilt.apidoc.spec.v0.models.Organization] and
        (__ \ "application").read[com.gilt.apidoc.spec.v0.models.Application] and
        (__ \ "namespace").read[String] and
        (__ \ "version").read[String] and
        (__ \ "base_url").readNullable[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "headers").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Header]].map(_.getOrElse(Nil)) and
        (__ \ "imports").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Import]].map(_.getOrElse(Nil)) and
        (__ \ "enums").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Enum]].map(_.getOrElse(Nil)) and
        (__ \ "unions").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Union]].map(_.getOrElse(Nil)) and
        (__ \ "models").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Model]].map(_.getOrElse(Nil)) and
        (__ \ "resources").readNullable[Seq[com.gilt.apidoc.spec.v0.models.Resource]].map(_.getOrElse(Nil))
      )(Service.apply _)
    }

    implicit def jsonWritesApidocspecService: play.api.libs.json.Writes[Service] = {
      (
        (__ \ "name").write[String] and
        (__ \ "organization").write[com.gilt.apidoc.spec.v0.models.Organization] and
        (__ \ "application").write[com.gilt.apidoc.spec.v0.models.Application] and
        (__ \ "namespace").write[String] and
        (__ \ "version").write[String] and
        (__ \ "base_url").write[scala.Option[String]] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "headers").write[Seq[com.gilt.apidoc.spec.v0.models.Header]] and
        (__ \ "imports").write[Seq[com.gilt.apidoc.spec.v0.models.Import]] and
        (__ \ "enums").write[Seq[com.gilt.apidoc.spec.v0.models.Enum]] and
        (__ \ "unions").write[Seq[com.gilt.apidoc.spec.v0.models.Union]] and
        (__ \ "models").write[Seq[com.gilt.apidoc.spec.v0.models.Model]] and
        (__ \ "resources").write[Seq[com.gilt.apidoc.spec.v0.models.Resource]]
      )(unlift(Service.unapply _))
    }

    implicit def jsonReadsApidocspecUnion: play.api.libs.json.Reads[Union] = {
      (
        (__ \ "name").read[String] and
        (__ \ "plural").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation] and
        (__ \ "types").readNullable[Seq[com.gilt.apidoc.spec.v0.models.UnionType]].map(_.getOrElse(Nil))
      )(Union.apply _)
    }

    implicit def jsonWritesApidocspecUnion: play.api.libs.json.Writes[Union] = {
      (
        (__ \ "name").write[String] and
        (__ \ "plural").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]] and
        (__ \ "types").write[Seq[com.gilt.apidoc.spec.v0.models.UnionType]]
      )(unlift(Union.unapply _))
    }

    implicit def jsonReadsApidocspecUnionType: play.api.libs.json.Reads[UnionType] = {
      (
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "deprecation").readNullable[com.gilt.apidoc.spec.v0.models.Deprecation]
      )(UnionType.apply _)
    }

    implicit def jsonWritesApidocspecUnionType: play.api.libs.json.Writes[UnionType] = {
      (
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "deprecation").write[scala.Option[com.gilt.apidoc.spec.v0.models.Deprecation]]
      )(unlift(UnionType.unapply _))
    }
  }
}

package com.gilt.apidoc.spec.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}
    import org.joda.time.{DateTime, LocalDate}
    import org.joda.time.format.ISODateTimeFormat
    import com.gilt.apidoc.spec.v0.models._

    // Type: date-time-iso8601
    implicit val pathBindableTypeDateTimeIso8601 = new PathBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    implicit val queryStringBindableTypeDateTimeIso8601 = new QueryStringBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    // Type: date-iso8601
    implicit val pathBindableTypeDateIso8601 = new PathBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )

    implicit val queryStringBindableTypeDateIso8601 = new QueryStringBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )

    // Enum: Method
    private val enumMethodNotFound = (key: String, e: Exception) => s"Unrecognized $key, should be one of ${com.gilt.apidoc.spec.v0.models.Method.all.mkString(", ")}"

    implicit val pathBindableEnumMethod = new PathBindable.Parsing[com.gilt.apidoc.spec.v0.models.Method] (
      Method.fromString(_).get, _.toString, enumMethodNotFound
    )

    implicit val queryStringBindableEnumMethod = new QueryStringBindable.Parsing[com.gilt.apidoc.spec.v0.models.Method](
      Method.fromString(_).get, _.toString, enumMethodNotFound
    )

    // Enum: ParameterLocation
    private val enumParameterLocationNotFound = (key: String, e: Exception) => s"Unrecognized $key, should be one of ${com.gilt.apidoc.spec.v0.models.ParameterLocation.all.mkString(", ")}"

    implicit val pathBindableEnumParameterLocation = new PathBindable.Parsing[com.gilt.apidoc.spec.v0.models.ParameterLocation] (
      ParameterLocation.fromString(_).get, _.toString, enumParameterLocationNotFound
    )

    implicit val queryStringBindableEnumParameterLocation = new QueryStringBindable.Parsing[com.gilt.apidoc.spec.v0.models.ParameterLocation](
      ParameterLocation.fromString(_).get, _.toString, enumParameterLocationNotFound
    )

  }

}


package com.gilt.apidoc.spec.v0 {

  object Constants {

    val UserAgent = "apidoc:0.8.18 http://localhost:9000/gilt/apidoc-spec/0.8.18/play_2_3_client"
    val Version = "0.8.18"
    val VersionMajor = 0

  }

  class Client(
    apiUrl: String,
    auth: scala.Option[com.gilt.apidoc.spec.v0.Authorization] = None
  ) {
    import com.gilt.apidoc.spec.v0.models.json._

    private val logger = play.api.Logger("com.gilt.apidoc.spec.v0.Client")

    logger.info(s"Initializing com.gilt.apidoc.spec.v0.Client for url $apiUrl")





    def _requestHolder(path: String): play.api.libs.ws.WSRequestHolder = {
      import play.api.Play.current

      val holder = play.api.libs.ws.WS.url(apiUrl + path).withHeaders(
        "User-Agent" -> Constants.UserAgent,
        "X-Apidoc-Version" -> Constants.Version,
        "X-Apidoc-Version-Major" -> Constants.VersionMajor.toString
      )
      auth.fold(holder) { a =>
        a match {
          case Authorization.Basic(username, password) => {
            holder.withAuth(username, password.getOrElse(""), play.api.libs.ws.WSAuthScheme.BASIC)
          }
          case _ => sys.error("Invalid authorization scheme[" + a.getClass + "]")
        }
      }
    }

    def _logRequest(method: String, req: play.api.libs.ws.WSRequestHolder)(implicit ec: scala.concurrent.ExecutionContext): play.api.libs.ws.WSRequestHolder = {
      val queryComponents = for {
        (name, values) <- req.queryString
        value <- values
      } yield name -> value
      val url = s"${req.url}${queryComponents.mkString("?", "&", "")}"
      auth.fold(logger.info(s"curl -X $method $url")) { _ =>
        logger.info(s"curl -X $method -u '[REDACTED]:' $url")
      }
      req
    }

    def _executeRequest(
      method: String,
      path: String,
      queryParameters: Seq[(String, String)] = Seq.empty,
      body: Option[play.api.libs.json.JsValue] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[play.api.libs.ws.WSResponse] = {
      method.toUpperCase match {
        case "GET" => {
          _logRequest("GET", _requestHolder(path).withQueryString(queryParameters:_*)).get()
        }
        case "POST" => {
          _logRequest("POST", _requestHolder(path).withQueryString(queryParameters:_*)).post(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PUT" => {
          _logRequest("PUT", _requestHolder(path).withQueryString(queryParameters:_*)).put(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PATCH" => {
          _logRequest("PATCH", _requestHolder(path).withQueryString(queryParameters:_*)).patch(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "DELETE" => {
          _logRequest("DELETE", _requestHolder(path).withQueryString(queryParameters:_*)).delete()
        }
         case "HEAD" => {
          _logRequest("HEAD", _requestHolder(path).withQueryString(queryParameters:_*)).head()
        }
         case "OPTIONS" => {
          _logRequest("OPTIONS", _requestHolder(path).withQueryString(queryParameters:_*)).options()
        }
        case _ => {
          _logRequest(method, _requestHolder(path).withQueryString(queryParameters:_*))
          sys.error("Unsupported method[%s]".format(method))
        }
      }
    }

  }

  object Client {

    def parseJson[T](
      className: String,
      r: play.api.libs.ws.WSResponse,
      f: (play.api.libs.json.JsValue => play.api.libs.json.JsResult[T])
    ): T = {
      f(play.api.libs.json.Json.parse(r.body)) match {
        case play.api.libs.json.JsSuccess(x, _) => x
        case play.api.libs.json.JsError(errors) => {
          throw new com.gilt.apidoc.spec.v0.errors.FailedRequest(r.status, s"Invalid json for class[" + className + "]: " + errors.mkString(" "))
        }
      }
    }

  }

  sealed trait Authorization
  object Authorization {
    case class Basic(username: String, password: Option[String] = None) extends Authorization
  }

  package errors {

    case class FailedRequest(responseCode: Int, message: String, requestUri: Option[_root_.java.net.URI] = None) extends Exception(s"HTTP $responseCode: $message")

  }

}