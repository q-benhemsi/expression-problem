# Tackling the Expression Problem in Scala

This repo contains a simple example of how to tackle the expression problem in Scala.

## The Expression Problem

Paraphrased from Wikipedia/provided by GitHub Copilot:

The goal of the expression problem is to be able to extend a data type with new variants and new operations on those variants without modifying the existing code, and without losing type safety.

During the rest of this document, I will refer to two types of extensibility:

1. Data type extensibility: the ability to add new variants to a data type without modifying the existing code.
2. Operation extensibility: the ability to add new operations (functions) on a data type without modifying the existing code.

## An example

This repo contains an example of the expression problem where you have been tasked to write a framework for creating pet shops. Pet shops want to be able to extend your framework by providing the types of pets they sell, and they want to define their own functions for gathering information about the pets they sell. Your framework needs to support both - simple! :)

## Guide to the modules

This repo contains separate modules for exploring different approaches to tackling the expression problem.

### [Non-extensible approach](non-extensible)

This module contains a simple example of how you may write a pet shop in Scala which supports dogs, cats and fish. The supported operations are the price of each pet, and whether two given pets are friends.

This module uses a `sealed trait` to represent a pet. This means that new pet types cannot be defined outside the file, so it is not data type extensible. New functions can be defined on `Pet` though, so it is operation extensible.

### [Simple OO approach](simple-oo)

### [Simple FP approach](simple-fp)

This module tries to tackle the issue using some simple FP. The pets are defined using a sum type. Operations are defined using functions which run pattern matching on the `Pet` type. This allows for operation extensibility since we can easily add new functions. In this example a function for defining the pet food for each pet is added. Data type extensibility since the sum type is a `sealed trait` which cannot be extended outside the file.

### [FP typeclass approach](fp-typeclass)

### [Mixed OO-FP approach](mixed-oo-fp)