package com.github.akajuvonen.neuralnet_scala

class Neuralnet {
  /* The neuralnet class.
   * TODO
   */
   def print() {
     // Prints only this for now
     println("Hi, this is NeuralNet")
     SigmoidTools.sigmoid()
   }
}

object Neuralnet {
  def main(args: Array[String]) {
    val nnet : Neuralnet = new Neuralnet
  }
}
