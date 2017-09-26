package com.github.akajuvonen.neuralnet_scala

/** MPL neural network class. */
class Neuralnet {
  /** Prints greetings (placeholder). */
  def sayHi() {
    // Prints only this for now
    println("Hi, this is NeuralNet")
    println(SigmoidTools.sigmoid(0.0))
  }
}

/** Neuralnet object for running from cli etc. */
object Neuralnet {
  def main(args: Array[String]) {
    val nnet : Neuralnet = new Neuralnet
    nnet.sayHi()
  }
}
