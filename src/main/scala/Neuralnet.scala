package com.github.akajuvonen.neuralnet_scala

import scala.util.Random

/** MPL neural network class.
 *
 *  @constructor Init a new neuralnet with training data (double vectors).
 *  @param trainIn training input data vector
 *  @param trainOut training output data vector
 *  @param hidSize number of nodes in hidden layer
 *  @param maxIter max number of iterations to run
 */
class Neuralnet(trainIn: Vector[Vector[Double]],
                trainOut: Vector[Vector[Double]], hidSize: Int, maxIter: Int) {

    /** Init a new neuralnet with type int vectors.
     *
     *  @param trainIn training input data vector
     *  @param trainOut training output data vector
     *  @param hidSize number of nodes in hidden layer
     *  @param maxIter max number of iterations to run
     *  @param dummy dummy variable needed because of type erasure, don't use
     */
    def this(trainIn: Vector[Vector[Int]], trainOut: Vector[Vector[Int]],
             hidSize: Int, maxIter: Int, dummy: Int = 0) {
      // Converts ints to doubles and calls the other constructor
      // Only one entry point is allowed in scala
      this(trainIn.map(_.map(_.toDouble)),
      trainOut.map(_.map(_.toDouble)), hidSize, maxIter)
    }

    /** The train method. TODO. */
    def train() {
      println("Training")
      classify()
    }

    /** Classify method */
    def classify() {
      println("Classifying")
      MatrixTools.multiply(trainIn, weights1)
    }

    println("Initializing")

    // Init weights randomly
    val r = Random
    // Weights between input and hidden layer
    // Size trainIn(0).length * hidden size
    val weights1 = trainIn(0).map(_ => 1.to(hidSize).to[Vector].map(_ => r.nextDouble))
    // Weights between hidden and output layer
    // Size hidden size * trainOut.length
    val weights2 = 1.to(hidSize).to[Vector].map(_ => trainOut(0).map(_ => r.nextDouble))
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
  val trainOut = Vector(
    Vector(1),
    Vector(0),
    Vector(1),
    Vector(1),
    Vector(0),
    Vector(0)
  )
  // Hidden layer size and maximum interations
  val hiddenSize = 4
  val maxIterations = 60000
  // Init neuralnet
  val nnet: Neuralnet = new Neuralnet(trainIn, trainOut,
                                      hiddenSize, maxIterations)
  nnet.train()
}
