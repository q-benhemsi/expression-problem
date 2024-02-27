package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base._
import BirdTCInstances._
import PetFood._

object PetShop extends App {

  /** This does not contain any `Pet` type!
   * All functionality is defined in separate typeclasses which are accumulated in `ExtendedPetTypeclasses`.
   * Therefore, `TCBox[ExtendedPetTypeclasses]` contains ever operation we can call on a pet. */
  val pets: List[TCBox[ExtendedPetTypeclasses]] = List(
    MkTCBox(Dog)(ExtendedPetTypeclasses()),
    MkTCBox(Bird)(ExtendedPetTypeclasses()),
  )

  val totalCost = pets.map(pet => pet.instance.pet.price(pet.value)).sum
  val foodTheyEat = pets.map(pet => pet.instance.petFood.food(pet.value)).mkString(", ")

  println(s"You can buy ${pets.map(_.value).mkString(", ")} together. This costs $totalCost and they eat $foodTheyEat.")
}
