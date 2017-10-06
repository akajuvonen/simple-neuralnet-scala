package com.github.akajuvonen.neuralnet_scala

/** MPL neural network class.
 *
 *  @constructor Init a new neuralnet with training data (double vectors).
 *  @param trainIn training input data vector
 *  @param trainOut training output data vector
 *  @param hidSize number of nodes in hidden layer
 *  @param maxIter max number of iterations to run
 */
class Neuralnet(trainIn: Vector[Double], trainOut: Vector[Double],
  hidSize: Int, maxIter: Int) {
    /** Init a new neuralnet with type int vectors.
     *
     *  @param trainIn training input data vector
     *  @param trainOut training output data vector
     *  @param hidSize number of nodes in hidden layer
     *  @param maxIter max number of iterations to run
     *  @param dummy dummy variable needed because of type erasure, don't use
    */
    def this(trainIn: Vector[Int], trainOut: Vector[Int],
    hidSize: Int, maxIter: Int, dummy: Int = 0) {
      this(trainIn.map(_.toDouble).to[Vector],
      trainOut.map(_.toDouble).to[Vector], hidSize, maxIter)
    }
}

/** Neuralnet object for running from cli etc. */
object Neuralnet extends App {
  // Consider this the "main" method
  // Training inputs
  val trainIn = Vector(
    Vector(1, 0, 0),
    Vector(0, 0, 1),
    Vector(1, 1, 1),
    Vector(1, 1, 0),
    Vector(0, 1, 0),
    Vector(0, 0, 0)
  )
  // Training outputs
  val trainOut = Vector(1, 0, 1, 1, 0, 0)
  //val nnet: Neuralnet = new Neuralnet(trainIn, trainOut)
}
