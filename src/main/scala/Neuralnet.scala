package com.github.akajuvonen.neuralnet_scala

object Neuralnet extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "Hi, this is neuralnet"
}
