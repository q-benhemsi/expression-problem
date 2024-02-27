# Mixed OO and FP approach

Now that we have seen both the OO and FP approaches, we can use Scala's hybrid stance and have a go at combining the two to see if we can get the best of both worlds. This module copies the approach in [fp-typeclasses](../fp-typeclasses/README.md), but tries to solve the issue that we were not able to define the `hasFriends` function.

## Approach

Compared to fp-typeclasses approach, `Pet` is now defined as an `abstract class` instead of a typeclass. This allows us to define a `HasFriends` typeclass.

## Results

Data type extensibility: ✅
- `Pet` is an `abstract class` which we can define new instances of.

Operation extensibility: ✅
- We can define new typeclasses which all of the `Pet` types can implement.

TODO: add a bit about the HasFriends relationship stuff.