package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._
import ExtendedHasFriendsInstances._
import BirdTCInstances._

object PetShop extends App {

  def getExtendedPet[PetType <: Pet: HasPrice: PetFood: HasFriends](pet: PetType): (Pet, TCBox[ExtendedPetTypeclasses]) = {
    pet -> MkTCBox[ExtendedPetTypeclasses, PetType](pet)(ExtendedPetTypeclasses())
  }

  val petsToBuy: List[(Pet, TCBox[ExtendedPetTypeclasses])] = List(
    getExtendedPet(Dog),
//    getExtendedPet(new Cat),
//    getExtendedPet(new Fish),
    getExtendedPet(Bird)
  )
  val pets = petsToBuy.map(_._1)
  val petTCBoxes = petsToBuy.map(_._2)

  if (ExtendedPetTypeclasses.canBuyPets(petsToBuy)) {
    val totalCost = petTCBoxes.map(extendedPet => extendedPet.instance.hasPrice.price(extendedPet.value)).sum
    val foodToBuy = petTCBoxes.map(extendedPet => extendedPet.instance.petFood.food(extendedPet.value)).mkString(", ")
    println(s"You can buy ${pets.mkString(", ")} together. This costs $totalCost and they eat $foodToBuy.")
  } else {
    println(s"Pets ${pets.mkString(", ")} cannot be bought together.")
  }

}
