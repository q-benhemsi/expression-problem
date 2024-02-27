package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._
import ExtendedHasFriendsInstances._
import BirdTCInstances._

object PetShop extends App {

  def getExtendedPet[PetType <: Pet](pet: PetType)(implicit hasPrice: HasPrice[PetType], petFood: PetFood[PetType], hasFriends: HasFriends[PetType]): (Pet, TCBox[ExtendedPetTypeclasses]) = {
    pet -> MkTCBox[ExtendedPetTypeclasses, PetType](pet)(ExtendedPetTypeclasses())
  }

  val petsToBuy: Map[Pet, TCBox[ExtendedPetTypeclasses]] = List(
    getExtendedPet(Dog),
//    getExtendedPet(new Cat),
//    getExtendedPet(new Fish),
    getExtendedPet(Bird)
  ).toMap

  if (ExtendedPetTypeclasses.canBuyPets(petsToBuy)) {
    val totalCost = petsToBuy.values.map(extendedPet => extendedPet.instance.hasPrice.price(extendedPet.value)).sum
    val foodToBuy = petsToBuy.values.map(extendedPet => extendedPet.instance.petFood.food(extendedPet.value)).mkString(", ")
    println(s"You can buy ${petsToBuy.keys.mkString(", ")} together. This costs $totalCost and they eat $foodToBuy.")
  } else {
    println(s"Pets ${petsToBuy.keys.mkString(", ")} cannot be bought together.")
  }

}
