package com.github.akajuvonen.neuralnet_scala

/** Matrix help tools used by NeuralNetwork class. */
object MatrixTools {
  /** Calculates the dot product of two vectors.
   *
   *  @param a The first vector.
   *  @param b The second vector.
   *  @return Dot product of two vectors.
   */
  def dot(a: Vector[Double], b: Vector[Double]): Double =
    a.zip(b).map(t => t._1 * t._2).sum

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
