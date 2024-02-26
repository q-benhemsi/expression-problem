package expression.problem.simple.oo

import expression.problem.simple.oo.ExtendedPets._

object PetShop extends App {
  val petsToBuy: List[Pet] = List(new ExtendedDog(), new ExtendedFish(), new Bird())

  if (Pet.canBuyPets(petsToBuy)) {
    println(s"You can buy ${petsToBuy.mkString(", ")} together. This costs ${Pet.totalCost(petsToBuy)}.")
  } else {
    println(s"Pets ${petsToBuy.map(_.toString).mkString(", ")} cannot be bought together.")
  }
}
