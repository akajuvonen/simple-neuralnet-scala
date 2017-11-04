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
    a.zip(b).map(t => t._1 * t._2).reduceLeft(_ + _)

  /** Matrix multiplication method.
   *
   *  @param a The first matrix to multiply.
   *  @param b The second matrix to multiply.
   *  @return Matrix multiplication result.
   */
  def multiply(a: Vector[Vector[Double]], b: Vector[Vector[Double]])
               : Vector[Vector[Double]] = {
    for(arow <- a) yield
    for(bcol <- b.transpose) yield
    dot(arow, bcol)
  }

  /** Matrix substraction.
   *
   *  @param a Matrix to substract from.
   *  @param b Matrix to be substracted from a.
   *  @return Substraction result.
   */
  def substract(a: Vector[Vector[Double]], b: Vector[Vector[Double]])
               : Vector[Vector[Double]] = {
    for((arow, brow) <- a.zip(b)) yield
    for((aelem, belem) <- arow.zip(brow))yield
    aelem - belem
  }

  /** Element-wise matrix multiplication.
   *
   *  @param a First matrix to multiply.
   *  @param b Second matrix to multiply.
   *  @return Element-wise multiplied matrix.
   */
  def multiplyElementwise(a: Vector[Vector[Double]], b: Vector[Vector[Double]])
                          : Vector[Vector[Double]] = {
    0.to(a.length-1).to[Vector]
      .map(i => 0.to(a(i).length-1).to[Vector]
        .map(j => a(i)(j) * b(i)(j)))
  }

}
