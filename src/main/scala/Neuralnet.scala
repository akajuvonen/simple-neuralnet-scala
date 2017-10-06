package com.github.akajuvonen.neuralnet_scala

/** MPL neural network class. */
class Neuralnet(hidSize: Int = 4, maxIter: Int = 60000) {
  /** Prints greetings (placeholder). */
  def sayHi() {
    // Prints only this for now
    println("Hi, this is NeuralNet")
    println(SigmoidTools.sigmoid(0.0))
  }
}

/** Neuralnet object for running from cli etc. */
object Neuralnet extends App {
  // Consider this the "main" method
  // Training inputs
  val trainIn = Vector(
    Vector(1, 0, 0),
    Vector(0, 0, 1),
    Vector(1, 1, 1),
    Vector(1, 1, 0),
    Vector(0, 1, 0),
    Vector(0, 0, 0)
  )
  // Training outputs
  val trainOut = Vector(1, 0, 1, 1, 0, 0)
  val nnet: Neuralnet = new Neuralnet
  nnet.sayHi()
}
