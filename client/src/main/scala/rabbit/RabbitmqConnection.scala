import com.rabbitmq.client.{ConnectionFactory, Delivery}

trait RabbitmqConnection{
  val factory = new ConnectionFactory
  val exchangeName: String = "topicLogs"
  val exchangeType: String = "topic"
  var routingKey: String = "prova." //potrebbe essere migliorato -> cambiare struttura classi
  val charsetName = "UTF-8"
}

class RabbitmqEmitter extends RabbitmqConnection {

  def SendMessage(message: String, logName: String = "*") = {
    try{
      val connection = factory.newConnection
      val channel = connection.createChannel

      // exchange configuration
      routingKey = routingKey + logName
      channel.exchangeDeclare(exchangeName, exchangeType)
      try{
        //send message
        channel.basicPublish(exchangeName, routingKey, null, message.getBytes(charsetName))
        System.out.println(" [x] Sent to " + routingKey + ": '" + message + "'")

      } catch {
        case _ => println("Error in sending")
      } finally {
        if (channel.isOpen) channel.close()
        if (connection.isOpen) connection.close()
      }
    } catch {
      case _ => println("Error in connect creation")
    }
  }

}

class RabbitmqReciver extends RabbitmqConnection {

  def work(callback: String => Unit, logName: String = "*"): Unit = {
    try{
      val connection = factory.newConnection
      val channel = connection.createChannel

      // queue configuration
      channel.exchangeDeclare(exchangeName, exchangeType)
      val queueName = channel.queueDeclare.getQueue
      routingKey = routingKey + logName
      channel.queueBind(queueName, exchangeName, routingKey)

      //recive message
      val autoAck = true
      channel.basicConsume(queueName, autoAck,
        (consumerTag: String, delivery: Delivery) => {
          val message = new String(delivery.getBody, charsetName)
          callback(message)
        },
        (consumerTag: String) => {})
    } catch {
      case _ => println("Error in reciver")
    }

  }
}