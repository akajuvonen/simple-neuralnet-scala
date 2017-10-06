package com.github.akajuvonen.neuralnet_scala

/** MPL neural network class.
 *
 *  @constructor Init a new neuralnet with training data (double vectors).
 *  @param trainIn training input data vector
 *  @param trainOut training output data vector
 *  @param hidSize number of nodes in hidden layer
 *  @param maxIter max number of iterations to run
 */
class Neuralnet(trainIn: Vector[Vector[Double]], trainOut: Vector[Double],
  hidSize: Int, maxIter: Int) {
    /** Init a new neuralnet with type int vectors.
     *
     *  @param trainIn training input data vector
     *  @param trainOut training output data vector
     *  @param hidSize number of nodes in hidden layer
     *  @param maxIter max number of iterations to run
     *  @param dummy dummy variable needed because of type erasure, don't use
    */
    def this(trainIn: Vector[Vector[Int]], trainOut: Vector[Int],
    hidSize: Int, maxIter: Int, dummy: Int = 0) {
      this(trainIn.map(_.map(_.toDouble)),
      trainOut.map(_.toDouble), hidSize, maxIter)
    }
    // Neuralnet just prints training data for now, should all be doubles
    trainIn foreach println
    trainOut foreach println
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
  // Init neuralnet
  val nnet: Neuralnet = new Neuralnet(trainIn, trainOut, 4, 60000)
}
