package expression.problem.mixed.oo.fp.base

import scala.annotation.tailrec

trait HasFriends[PetType] {
  def isFriend(pet1: PetType, pet2: Pet): Boolean
}

object HasFriends {
  def canBuyPets(pets: Map[Pet, TCBox[HasFriends]]): Boolean = {
    @tailrec
    def checkIfPetIsFriend(remainingPets: List[(Pet, TCBox[HasFriends])], accumulatedPets: Set[Pet]): Boolean = {
      remainingPets match {
        case Nil => true
        case (pet, hasFriendsTC) :: tl =>
          val isFriendsWithAllAccumulatedPets = accumulatedPets.forall { accumulatedPet =>
            val isFriend1 = hasFriendsTC.instance.isFriend(hasFriendsTC.value, accumulatedPet)
            val accumulatedPetHasFriendsTC = pets(accumulatedPet)
            val isFriend2 = accumulatedPetHasFriendsTC.instance.isFriend(accumulatedPetHasFriendsTC.value, pet)
            isFriend1 && isFriend2
          }
          if (isFriendsWithAllAccumulatedPets) checkIfPetIsFriend(tl, accumulatedPets + pet)
          else false
      }
    }
    checkIfPetIsFriend(pets.toList, Set.empty)
  }
}