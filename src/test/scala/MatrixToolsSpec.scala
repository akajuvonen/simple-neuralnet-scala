package com.github.akajuvonen.neuralnet_scala

import org.scalatest._

/** MatrixTools test class. */
class MatrixToolsSpec extends FlatSpec {
  ignore should "do matrix multiplication" in {
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
      Vector(14.0, 22.0),
      Vector(22.0, 29.0)
    )
    val result = MatrixTools.multiply(a, b)
    assert(result == expected)
  }
}
