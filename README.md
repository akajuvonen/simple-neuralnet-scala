# simple-neuralnet-scala
A simple MLP neural network implemented in Scala

## Requirements

This neural net is programmed using [Scala](https://www.scala-lang.org/).
You also need to install [SBT](http://www.scala-sbt.org/) (Simple Build Tool).
All other dependencies are automatically handled by SBT.
Note: Everything is programmed and tested only in Ubuntu 17.04.

## Compiling and running

Use `sbt compile` to compile the program. It can be run using `sbt run`.
If  you want to create a jar package, run `sbt package`. The package will
appear in `target/scala-x.xx/`.

## Running tests

Unit tests can be run with `sbt test`.

## Cleaning

To clean the files in target folders, run `sbt clean`.
