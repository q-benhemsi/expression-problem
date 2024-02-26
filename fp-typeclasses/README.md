# FP typeclasses approach

This module attempts to tackle the issue by representing `Pet` using a typeclass.

## Typeclasses

Typeclasses are an FP construct. They allow us to use the same function for different types which is called ad-hoc polymorphism. We can think of typeclasses with the following Scala pseudo code for the `AddOne` typeclass:

First we define the typeclass:
```scala
typeclass AddOne[A] {
  def addOne(x: A): A
}
```

Then we define instances of the typeclass for different types:
```scala
instance AddOne[Int] {
  def addOne(x: Int): Int = x + 1
}

instance AddOne[Double] {
  def addOne(x: Double): Double = x + 1
}

instance AddOne[String] {
  def addOne(x: String): String = x ++ " + 1"
}
```

Then we can define a function which uses the typeclass:
```scala
def addTwo[A: AddOne](x: A): A = addOne(addOne(x))
```

Here `A: AddOne` is a constraint that says the type `A` must have an instance of the `AddOne` typeclass.

We achieve typeclasses in Scala with implicits. See the [Pet](./src/main/scala/expression/problem/fp/typeclasses/Pet.scala) for an example typeclass for the pet shop example.

## Existential types

Typeclasses are a great approach to offer both data type and operation extensibility. However, they suffer when you want to have a list of items. This is because the typeclasses take a type parameter, and you cannot have a list of items of different types so the following does not compile:

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

However, we can never retrieve the original type once we form the existential type. The following code will not compile:

```scala
val existentialDog: TCBox[Pet] = MkTCBox(Dog)
val dog: Dog.type = existentialDog.value
// <console>:15: error: type mismatch;
//   found   : existentialDog.value.type (with underlying type existentialDog.T)
//   required: Dog.type
//   val dog: Dog.type = existentialDog.value
```

We can think of an existential type as swallowing the original type and only allowing us to use the typeclass instance.

## Results

Data type extensibility: ✅
- `Pet` is defined as a typeclass which allows us to define new pet types outside the file.

Operation extensibility: ✅
- We can define a new operation on `Pet` by defining a new typeclass and providing instances for each `Pet` type.

Relationships between types: ❌
- We cannot define the `areFriends` method because we do not know all the types of the pets.
