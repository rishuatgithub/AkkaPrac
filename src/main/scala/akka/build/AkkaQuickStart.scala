package akka.build

import akka.actor.{ActorRef, ActorSystem}

object AkkaQuickStart {

  def main(args: Array[String]): Unit = {

    val system: ActorSystem = ActorSystem("AkkaStartSystem")

    val printer: ActorRef = system.actorOf(Printer.props, "PrinterActor")

    // Create the 'greeter' actors
    val howdyGreeter: ActorRef =
      system.actorOf(Greeter.props("Howdy", printer), "howdyGreeter")
    val helloGreeter: ActorRef =
      system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
    val goodDayGreeter: ActorRef =
      system.actorOf(Greeter.props("Good day", printer), "goodDayGreeter")

    import Greeter._

    howdyGreeter ! WhoToGreet("Akka")
    howdyGreeter ! Greet

    howdyGreeter ! WhoToGreet("Lightbend")
    howdyGreeter ! Greet

    helloGreeter ! WhoToGreet("Scala")
    helloGreeter ! Greet

    goodDayGreeter ! WhoToGreet("Play")
    goodDayGreeter ! Greet

    goodDayGreeter ! WhoToGreet("Play")
    goodDayGreeter ! Greet
  }

}
