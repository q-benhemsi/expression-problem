package expression.problem.simple.fp.extended

import expression.problem.simple.fp.base._

object PetShop extends App {
  val petsToBuy: List[Pet] = List(Dog, Fish)

  if (Pet.canBuyPets(petsToBuy)) {
    println(s"You can buy ${petsToBuy.mkString(", ")} together. This costs ${Pet.totalCost(petsToBuy)}. You will need to buy the following foods: ${petsToBuy.map(ExtendedPets.petFood).mkString(", ")}.")
  } else {
    println(s"Pets ${petsToBuy.map(_.toString).mkString(", ")} cannot be bought together.")
  }
}