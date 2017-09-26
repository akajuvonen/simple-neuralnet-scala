package com.github.akajuvonen.neuralnet_scala

import scala.math.exp

/** Sigmoid help tools used by NeuralNetwork class. */
object SigmoidTools {
  /** Sigmoid function 1 / (1 + exp(-x)).
   *
   *  @param x Input parameter x.
   *  @return Result of the sigmoid function.
   */
  def sigmoid(x: Double): Double = {
    1.0 / (1 + exp(-x))
  }
}
