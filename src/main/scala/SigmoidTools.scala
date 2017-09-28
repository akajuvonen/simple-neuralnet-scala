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

  /** Sigmoid derivative function.
   *
   *  @param x Sigmoid function result.
   *  @return Derivative of the sigmoid function.
   */
  def sigmoidDerivative(x: Double): Double = {
    x * (1- x)
  }
}
