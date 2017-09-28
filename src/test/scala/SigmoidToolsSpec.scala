package com.github.akajuvonen.neuralnet_scala

import org.scalatest._

/** SigmoidTools test class. */
class SigmoidToolsSpec extends FlatSpec{
  "SigmoidTools.sigmoid" should
  "return appr. zero with small x values" in {
    assert(SigmoidTools.sigmoid(-100) < 0.01)
  }

  it should "return appr. one with large x values" in {
    assert(SigmoidTools.sigmoid(100) > 0.99)
  }

  it should "return 0.5 with x=0" in {
    assert(SigmoidTools.sigmoid(0.0) == 0.5)
  }

  "SigmoidTools.sigmoidDerivative" should
  "return appr. zero with small x values" in {
    assert(SigmoidTools.sigmoidDerivative(SigmoidTools.sigmoid(-10)) < 0.01)
  }

  it should "return 0.25 with x = 0" in {
    assert(SigmoidTools.sigmoidDerivative(SigmoidTools.sigmoid(0)) == 0.25)
  }

  it should "return appr. zero with large x values" in {
    assert(SigmoidTools.sigmoidDerivative(SigmoidTools.sigmoid(10)) < 0.01)
  }
}
