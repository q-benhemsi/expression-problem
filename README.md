# Tackling the Expression Problem in Scala

This repo contains different approaches for tackling the expression problem in Scala.

## The Expression Problem

Paraphrased from Wikipedia/provided by GitHub Copilot:

The goal of the expression problem is to be able to extend a data type with new variants and new operations on all of those variants without modifying the existing code, and without losing type safety.

From this we can talk about two types of extensibility:

1. Data type extensibility: the ability to add new variants to a data type without modifying the existing code.
2. Operation extensibility: the ability to add new operations (functions) on each and every data type without modifying the existing code.

## An example

This repo contains an example of the expression problem where we have been tasked with writing a framework for creating pet shops. Pet shops want to be able to extend your framework by providing the types of pets they sell, and they want to define their own functions for gathering information about the pets they sell. Your framework needs to support both - simple! :)

## Guide to the modules

This repo contains separate modules for exploring different approaches to tackling the expression problem.

1. [Non-extensible approach](./non-extensible/README.md)
2. [Simple OO approach](./simple-oo/README.md)
3. [Simple FP approach](./simple-fp/README.md)
4. [FP typeclasses approach](./fp-typeclasses/README.md)
5. [Mixed OO-FP approach](./mixed-oo-fp/README.md)
