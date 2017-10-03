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
object Neuralnet {
  def main(args: Array[String]): Unit = {
    val nnet: Neuralnet = new Neuralnet
    nnet.sayHi()
  }
}
