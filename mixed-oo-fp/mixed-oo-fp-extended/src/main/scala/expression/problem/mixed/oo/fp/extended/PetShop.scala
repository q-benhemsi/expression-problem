package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._
import ExtendedHasFriendsInstances._

object PetShop extends App {

  def getExtendedPet[T <: Pet](pet: T)(implicit petFood: PetFood[T], hasFriends: HasFriends[T]): (Pet, TCBox[ExtendedPetTypeclasses]) = {
    pet -> MkTCBox[ExtendedPetTypeclasses, T](pet)(ExtendedPetTypeclasses())
  }

  val petsToBuy: Map[Pet, TCBox[ExtendedPetTypeclasses]] = List(
    getExtendedPet(new Dog),
//    getExtendedPet(new Cat),
//    getExtendedPet(new Fish),
    getExtendedPet(new Bird)
  ).toMap

  if (ExtendedPetTypeclasses.canBuyPets(petsToBuy)) {
    println(s"You can buy ${petsToBuy.keys.mkString(", ")} together. This costs ${petsToBuy.keys.map(_.price).sum} and they eat ${petsToBuy.values.map(extendedPet => extendedPet.instance.petFood.food(extendedPet.value)).mkString(", ")}")
  } else {
    println(s"Pets ${petsToBuy.keys.mkString(", ")} cannot be bought together.")
  }

}
