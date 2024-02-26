# Non-extensible approach

This module contains a simple example of how you may write a pet shop in Scala which supports dogs, cats and fish. The supported operations are the price of each pet, and whether two given pets are friends.

This module uses a `sealed trait` to represent a pet. This means that new pet types cannot be defined outside the file, so it is not data type extensible. New functions can be defined on `Pet` though, so it is operation extensible.

