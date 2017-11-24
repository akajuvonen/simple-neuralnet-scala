package com.github.akajuvonen.neuralnet_scala

import scala.util.Random
import scala.annotation.tailrec

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

    /** Neural network train method using recursion.
     *
     *  @param weights1 Weights between input and hidden layer.
     *  @param weights2 Weights between hidden and output layer.
     *  @return New adjusted weights.
     */
    @tailrec
    private final def train(weights1: Vector[Vector[Double]],
              weights2: Vector[Vector[Double]],
              i: Int = 0):
              (Vector[Vector[Double]], Vector[Vector[Double]]) = {
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
      // If iterations full, return the weights
      if (i >= maxIter) (weights1New, weights2New)
      // Otherwise iterate more
      else train(weights1New, weights2New, i + 1)
    }

    /** Classifies data using neural net.
     *
     *  @param input Input data to classify.
     *  @param weights1 Weights between input and hidden layer.
     *  @param weights2 Weights between hidden and output layer.
     *  @return Hidden and output layers.
     */
    def classify(input: Vector[Vector[Double]],
                 weights1: Vector[Vector[Double]] = this.weights1,
                 weights2: Vector[Vector[Double]] = this.weights2):
                 (Vector[Vector[Double]], Vector[Vector[Double]]) = {
      val hiddenLayer = activateLayer(input, weights1)
      val outputLayer = activateLayer(hiddenLayer, weights2)
      (hiddenLayer, outputLayer)
    }

    /** Activates a single neural net layer.
     *
     *  @param layer Layer to activate (input or hidden).
     *  @param weights Weights associated with the layer.
     *  @return Layer inputs multiplied by weights.
     */
    private def activateLayer(layer: Vector[Vector[Double]],
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
    private def initWeights(n: Int, m: Int): Vector[Vector[Double]] = {
      1.to(n).to[Vector].map(_ => 1.to(m).to[Vector].map(_ => r.nextDouble))
    }

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
    Vector(1.0, 0.0, 0.0),
    Vector(0.0, 0.0, 1.0),
    Vector(1.0, 1.0, 1.0),
    Vector(1.0, 1.0, 0.0),
    Vector(0.0, 1.0, 0.0),
    Vector(0.0, 0.0, 0.0)
  )
  // Training outputs
  val trainOut = Vector(
    Vector(1.0),
    Vector(0.0),
    Vector(1.0),
    Vector(1.0),
    Vector(0.0),
    Vector(0.0)
  )
  val testIn = Vector(
    Vector(1.0, 0.0, 1.0),
    Vector(0.0, 0.0, 1.0),
    Vector(1.0, 1.0, 0.0)
  )
  // Hidden layer size and maximum interations
  val hiddenSize = 4
  val maxIterations = 60000
  // Init neuralnet
  val nnet: Neuralnet = new Neuralnet(trainIn, trainOut,
                                      hiddenSize, maxIterations)
  val (hidden, output) = nnet.classify(testIn)
  println("Classification result (should be 1 0 1):")
  output.map(_.map(i => println(i.round)))
}
