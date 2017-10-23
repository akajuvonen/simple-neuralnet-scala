package com.github.akajuvonen.neuralnet_scala

import org.scalatest._

/** MatrixTools test class. */
class MatrixToolsSpec extends FlatSpec {
  "MatrixTools.dot" should "calculate dot product" in {
    val a = Vector(1.0, 2.0, 3.0)
    val b = Vector(2.0, 3.0, 4.0)
    val expected = 20.0
    val result = MatrixTools.dot(a, b)
    assert(expected == result)
  }

  "MatrixTools.multiply" should "do matrix multiplication" in {
    val a = Vector(
      Vector(1.0, 2.0, 3.0),
      Vector(2.0, 3.0, 4.0)
    )
    val b = Vector(
      Vector(1.0, 2.0),
      Vector(2.0, 3.0),
      Vector(3.0, 4.0)
    )
    val expected = Vector(
      Vector(14.0, 20.0),
      Vector(20.0, 29.0)
    )
    val result = MatrixTools.multiply(a, b)
    assert(result == expected)
  }
}
