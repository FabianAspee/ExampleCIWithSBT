import spray.json._
import MessageJsonProtocol._
import scala.language.postfixOps

object Emit {
  private val emitter: RabbitmqEmitter = new RabbitmqEmitter

  def send(message: String) = emitter.SendMessage(message, "fuckoff")
}

object emit2 extends App {

  val message: JsValue = Message("ajeje", "brazorf", 213).toJson

  Emit.send(message.toString())
}
