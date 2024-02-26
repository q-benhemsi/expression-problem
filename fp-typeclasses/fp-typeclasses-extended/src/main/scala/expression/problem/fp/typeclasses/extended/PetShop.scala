package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base._
import BirdTCInstances._
import PetFood._

object PetShop extends App {
  val pets: List[TCBox[ExtendedPetTypeclasses]] = List(
    MkTCBox(Dog)(ExtendedPetTypeclasses()),
    MkTCBox(Bird)(ExtendedPetTypeclasses()),
  )

  println(s"You can buy ${pets.map(_.value).mkString(", ")} together. This costs ${pets.map(pet => pet.instance.pet.price(pet.value)).sum} and they eat ${pets.map(pet => pet.instance.petFood.food(pet.value)).mkString(", ")}")
}
