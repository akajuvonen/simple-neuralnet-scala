package com.github.akajuvonen.neuralnet_scala

import org.scalatest._

class NeuralnetSpec extends FlatSpec with Matchers {
  "The Neuralnet object" should "say: Hi, this is neuralnet" in {
    Neuralnet.greeting shouldEqual "Hi, this is neuralnet"
  }
}
