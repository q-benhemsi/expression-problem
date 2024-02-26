package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base.{HasFriends, Pet, TCBox}

import scala.annotation.tailrec

case class ExtendedPetTypeclasses[PetType]()(
  implicit val petFood: PetFood[PetType],
  val hasFriends: HasFriends[PetType]
)

object ExtendedPetTypeclasses {

  def canBuyPets(pets: Map[Pet, TCBox[ExtendedPetTypeclasses]]): Boolean = {
    @tailrec
    def checkIfPetIsFriend(remainingPets: List[(Pet, TCBox[ExtendedPetTypeclasses])], accumulatedPets: Set[Pet]): Boolean = {
      remainingPets match {
        case Nil => true
        case (pet, extendedPetTC) :: tl =>
          val isFriendsWithAllAccumulatedPets = accumulatedPets.forall { accumulatedPet =>
            val isFriend1 = extendedPetTC.instance.hasFriends.isFriend(extendedPetTC.value, accumulatedPet)
            val accumulatedPetHasFriendsTC = pets(accumulatedPet)
            val isFriend2 = accumulatedPetHasFriendsTC.instance.hasFriends.isFriend(accumulatedPetHasFriendsTC.value, pet)
            isFriend1 && isFriend2
          }
          if (isFriendsWithAllAccumulatedPets) checkIfPetIsFriend(tl, accumulatedPets + pet)
          else false
      }
    }
    checkIfPetIsFriend(pets.toList, Set.empty)
  }
}