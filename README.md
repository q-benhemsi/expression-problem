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

### [FP typeclasses approach](fp-typeclasses)

#### Typeclasses

Typeclasses are an FP construct which originated in Haskell. They provide ad-hoc polymorphism which allows us to use the same function for different types. We can think of typeclasses with the following Scala pseudo code for the `Num` typeclass which defines methods that numbers share in common:

First we define the typeclass:

```scala
typeclass AddOne[A] {
  def addOne(x: A): A
}
```

Then we define instances of the typeclass for different types:
```scala
instance Num[Int] {
  def addOne(x: Int): Int = x + 1
}

instance Num[Double] {
  def addOne(x: Double): Double = x + 1
}
```

Then we can define a function which uses the typeclass:

```scala
def addTwo[A: Num](x: A): A = addOne(addOne(x))
```

Here `A: Num` is a constraint that says the type `A` must have an instance of the `Num` typeclass.

We achieve typeclasses in Scala with implicits. See the [Pet](./fp-typeclasses/src/main/scala/expression/problem/fp/typeclass/Pet.scala) for an example typeclass for the pet shop example.

#### Existential types

Typeclasses offer are a great approach to offer both data type and operation extensibility. However, they suffer when you want to have a list of items. This is because the typeclasses take a type parameter, and you cannot have a list of items of different types so the following does not compile:

```scala
val pets: List[Pet[?!]] = List(Dog, Cat, Fish)
```

This is where existential types come in. They allow us to extract a typeclass instance from a given type.

```scala
trait TCBox[Typeclass[_]] {
  type T
  val value: T
  val instance: Typeclass[T]
}

case class MkTCBox[Typeclass[_], A](value: A)(implicit val instance: Typeclass[A]) extends TCBox[Typeclass] {
  type T = A
}
```

Now we can form a list of pets and calculate their total cost:

```scala
val pets: List[TCBox[Pet]] = List(MkTCBox(Dog), MkTCBox(Cat), MkTCBox(Fish))
val totalCost = pets.map(pet => pet.instance.price(pet.value)).sum
```

However, we can never retrieve the original type once we form the existential type. The following code will not compile

```scala
val existentialDog: TCBox[Pet] = MkTCBox(Dog)
val dog: Dog.type = existentialDog.value
// <console>:15: error: type mismatch;
//   found   : existentialDog.value.type (with underlying type existentialDog.T)
//   required: Dog.type
//   val dog: Dog.type = existentialDog.value
```

We can think of an existential type as swallowing the original type and only allowing us to use the typeclass instance.

### [Mixed OO-FP approach](mixed-oo-fp)

Now that we have seen both the OO and FP approaches, let's use Scala's hybrid stance and have a go at combining the two to see if we can get the best of both worlds. This modules tries the following:

- Pet is represented using an `abstract class` which allows data type extensibility from the OO approach.
- `Pet` defines the `price` method which all pets must implement.
- Additional operations are defined using typeclasses which allows the operational extensibility from the FP approach. In this example, there is a typeclass for `PetFood`.
- 