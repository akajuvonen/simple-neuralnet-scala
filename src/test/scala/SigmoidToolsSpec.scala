package com.github.akajuvonen.neuralnet_scala

import org.scalatest._

/** SigmoidTools test class. */
class SigmoidToolsSpec extends FlatSpec{
  "The SigmoidTools object" should
  "return appr. zero with small x values for sigmoid function" in {
    assert(SigmoidTools.sigmoid(-100) < 0.01)
  }

  it should "return appr. one with high x values for sigmoid function" in {
    assert(SigmoidTools.sigmoid(100) > 0.99)
  }

  it should "return 0.5 with x=0 in sigmoid function" in {
    assert(SigmoidTools.sigmoid(0.0) == 0.5)
  }
}
