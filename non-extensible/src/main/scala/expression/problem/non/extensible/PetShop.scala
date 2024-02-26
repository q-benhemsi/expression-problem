package expression.problem.non.extensible

object PetShop extends App {
  val petsToBuy: List[Pet] = List(Dog, Fish)

  if (Pet.canBuyPets(petsToBuy)) {
    println(s"You can buy ${petsToBuy.mkString(", ")} together. This costs ${Pet.totalCost(petsToBuy)}.")
  } else {
    println(s"Pets ${petsToBuy.map(_.toString).mkString(", ")} cannot be bought together.")
  }

}