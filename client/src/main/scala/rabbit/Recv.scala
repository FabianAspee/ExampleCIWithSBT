import spray.json._
import MessageJsonProtocol._

object Recv {
  private val reciver: RabbitmqReciver = new RabbitmqReciver

  def work(callback: String => Unit, logName: String = "*") = reciver.work(callback, logName)
}

object r1 extends App {
  Recv.work(s => println(s), "fuckoff")
}

object r2 extends App {
  Recv.work(s => println(s), "bitches")
}

object r3 extends App {
  Recv.work(s => {
    println(s)
    val msg = s.parseJson.convertTo[Message]
    println(msg.payload)
  })
}
