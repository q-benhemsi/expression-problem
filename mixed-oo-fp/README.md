# Mixed OO and FP approach

Now that we have seen both the OO and FP approaches, let's use Scala's hybrid stance and have a go at combining the two to see if we can get the best of both worlds. This modules tries the following:

- Pet is represented using an `abstract class` which allows data type extensibility from the OO approach.
- `Pet` defines the `price` method which all pets must implement.
- Additional operations are defined using typeclasses which allows the operational extensibility from the FP approach. In this example, there is a typeclass for `PetFood`.
- 
