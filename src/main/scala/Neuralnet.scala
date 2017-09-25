package com.github.akajuvonen.neuralnet_scala

class Neuralnet {
  /* The neuralnet class.
   * TODO
   */
   def sayHi() {
     // Prints only this for now
     println("Hi, this is NeuralNet")
     SigmoidTools.sigmoid()
   }
}

object Neuralnet {
  /* NeuralNet object.
   * Used to execute the main method when not importing the neural net.
   */
  def main(args: Array[String]) {
    val nnet : Neuralnet = new Neuralnet
    nnet.sayHi()
  }
}
