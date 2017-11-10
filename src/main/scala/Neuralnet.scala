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
    def train(weights1: Vector[Vector[Double]],
              weights2: Vector[Vector[Double]]):
              (Vector[Vector[Double]], Vector[Vector[Double]]) = {
      println("Training")
      val (hiddenLayer, outputLayer) = classify(trainIn, weights1, weights2)
      val outputError = MatrixTools.substract(trainOut, outputLayer)
      /** Multiply element-wise the output error and the sigmoid Derivative
          applied to all elements of output layer. */
      val outputAdjustment = MatrixTools.multiplyElementwise(outputError,
                               outputLayer.map(
                                 _.map(SigmoidTools.sigmoidDerivative(_))))
      val hiddenError = MatrixTools.multiply(outputAdjustment,
                                            weights2.transpose)
      val hiddenAdjustment = MatrixTools.multiplyElementwise(hiddenError,
                              hiddenLayer.map(
                                _.map(SigmoidTools.sigmoidDerivative(_))))
      // Update the weights
      val weights2New = MatrixTools.add(weights2,
        MatrixTools.multiply(hiddenLayer.transpose,
          outputAdjustment))
      val weights1New = MatrixTools.add(weights1,
        MatrixTools.multiply(trainIn.transpose,
          hiddenAdjustment))
      (weights1New, weights2New)
    }

    /** Classify method */
    def classify(input: Vector[Vector[Double]],
                 weights1: Vector[Vector[Double]],
                 weights2: Vector[Vector[Double]]):
                 (Vector[Vector[Double]], Vector[Vector[Double]]) = {
      println("Classifying")
      val hiddenLayer = activateLayer(input, weights1)
      val outputLayer = activateLayer(hiddenLayer, weights2)
      (hiddenLayer, outputLayer)
    }

    def activateLayer(layer: Vector[Vector[Double]],
                      weights: Vector[Vector[Double]])
                      : Vector[Vector[Double]] = {
      val multiplied = MatrixTools.multiply(layer, weights)
      for (row <- multiplied) yield
      for (element <- row) yield
      SigmoidTools.sigmoid(element)
    }

    /** Initialize a random weight vector.
     *
     *  @param n Vector rows.
     *  @param m Vector columns.
     * @return A randomly initialized weight vector.
     */
    def initWeights(n: Int, m: Int): Vector[Vector[Double]] = {
      1.to(n).to[Vector].map(_ => 1.to(m).to[Vector].map(_ => r.nextDouble))
    }

    println("Initializing")

    // Init weights randomly
    val r = Random
    // Weights between input and hidden layer
    val weights1Init = initWeights(trainIn(0).length, hidSize)
    // Weights between hidden and output layer
    val weights2Init = initWeights(hidSize, trainOut(0).length)
    val (weights1, weights2) = train(weights1Init, weights2Init)
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
}
