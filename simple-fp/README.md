# Simple FP approach

This module tries to tackle the issue using some simple FP. The pets are defined using a sum type. Operations are defined using functions which run pattern matching on the `Pet` type.

## Sum types

A sum type (AKA coproduct type) is a type that takes one of a fixed set of values. We can think of it as an `OR` type:

```
type Pet = Dog OR Cat OR Fish
```

in Scala, we represent this using a `sealed trait`:

```scala
sealed trait Pet
case object Dog extends Pet
case object Cat extends Pet
case object Fish extends Pet
```

Other familiar sum types are `Option` and `Either`.

## Pattern matching

Sum types go hand-in-hand with pattern matching. When defining operations for `Pet`, we pattern match on each of the possible values of `Pet` and define the logic for that given `Pet`.

## Results

Data type extensibility: ❌
- `Pet` is a `sealed trait` which means it cannot be extended outside the file.

Operation extensibility: ✅
- We can define new functions which pattern match on the `Pet` type.