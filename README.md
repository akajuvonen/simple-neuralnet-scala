# simple-neuralnet-scala
A simple MLP neural network implemented in Scala.

## Requirements

This neural net is programmed using [Scala](https://www.scala-lang.org/).
You also need to install [SBT](http://www.scala-sbt.org/) (Simple Build Tool).
All other dependencies are automatically handled by SBT.
Note: Everything is programmed and tested only in Ubuntu 17.04.

## Compiling and running

Use `sbt compile` to compile the program. It can be run using `sbt run`.
If  you want to create a jar package, run `sbt package`. The package will
appear in `target/scala-x.xx/`.

## Usage

First we have to define training data input and output vectors (should be type
*Double*).

```scala
val trainIn = Vector(
  Vector(1.0, 0.0, 1.0),
  Vector(0.0, 0.0, 1.0),
  ...
)
val trainOut = Vector(
  Vector(1.0),
  Vector(0.0),
  ...
)
```

Then we need to determine some parameters: hidden layer size (in nodes) and
maximum number of iterations to run.

```scala
val hiddenSize = 4
val maxIterations = 60000
```

Now we can initialize and train the network.

```scala
val nnet: Neuralnet = new Neuralnet(trainIn, trainOut, hiddenSize,
                                    maxIterations)
```

When we want to classify new data, first the testing data must be defined
(similar as `trainIn`). The `classify()` method returns both the hidden and
output layer. The output layer is the classification result.

```scala
val testIn = Vector(
  Vector(1.0, 1.0, 1.0),
  Vector(0.0, 1.0, 0.0),
  ...
)
val (hidden, output) = nnet.classify(testIn)
```

## Running tests

Unit tests can be run with `sbt test`.

## Cleaning

To clean the files in target folders, run `sbt clean`.
