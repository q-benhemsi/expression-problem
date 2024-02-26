# Simple OO approach

This module uses a simple OO approach to tackle the issue. `Pet` is represented as an `abstract class` which the different `Pet` types extend.

## Results

Data type extensibility: ✅
- We can define new `Pet` types by extending the `Pet` class.
- We can extend existing `Pet` types if we want to override the behaviour of a method.
- When adding a new `Pet`, we need to extend existing pets if we have any methods which reference other pets.

Operation extensibility: ❌
- We cannot add a new operation to the `Pet` class without modifying the class itself.
- We can add functions which act on `Pet` types, but these functions will not be part of the `Pet` class.
