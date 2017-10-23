package com.github.akajuvonen.neuralnet_scala

/** Matrix help tools used by NeuralNetwork class. */
object MatrixTools {
  /** TODO */
  def dot(a: Vector[Double], b: Vector[Double]): Double = {
    1.0
  }
  /** Matrix multiplication method.
   *
   * @param a The first matrix to multiply.
   * @param b The second matrix to multiply.
   * @return Matrix multiplication result.
   */
  def multiply(a: Vector[Vector[Double]], b: Vector[Vector[Double]])
               : Vector[Vector[Double]] = {
    Vector(Vector(1.0, 2.0))
  }
}
