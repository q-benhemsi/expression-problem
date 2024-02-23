package expression.problem.non.extensible

object Main extends App {
  val petsToBuy: List[Pet] = List(Dog, Fish)

  if (Pet.canBuyPets(petsToBuy)) {
    println(s"You can buy ${petsToBuy.mkString(", ")} together. You need to buy the following food: ${Pet.foodsToBuy(petsToBuy).mkString(", ")}")
  } else {
    println(s"Pets ${petsToBuy.map(_.toString).mkString(", ")} cannot be bought together.")
  }
}