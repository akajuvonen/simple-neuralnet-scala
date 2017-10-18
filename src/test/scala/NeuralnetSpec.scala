package com.github.akajuvonen.neuralnet_scala

import org.scalatest._

class NeuralnetSpec extends FlatSpec {
  "Neuralnet" should "init weights randomly" in {
    val trainIn = Vector(Vector(1, 0), Vector(0, 1))
    val trainOut = Vector(
      Vector(1),
      Vector(0)
    )
    val hidSize = 4
    val net = new Neuralnet(trainIn, trainOut, hidSize, 60000)
    // Check the weight matrix sizes
    assert(net.weights1.length == trainIn(0).length)
    assert(net.weights1(0).length == hidSize)
    assert(net.weights2.length == hidSize)
    assert(net.weights2(0).length == trainOut(0).length)
    // Check that the values are between 0 and 1
    assert(net.weights1.flatten.max < 1.0)
    assert(net.weights1.flatten.min > 0.0)
    assert(net.weights2.flatten.max < 1.0)
    assert(net.weights2.flatten.min > 0.0)
  }
}
