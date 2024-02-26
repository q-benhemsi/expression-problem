package expression.problem.simple.oo

import scala.annotation.tailrec

abstract class Pet {
  def price: Double
  def isFriend(pet: Pet): Boolean
}

object Pet {
  def totalCost(pets: List[Pet]): Double = pets.map(_.price).sum

  def canBuyPets(pets: List[Pet]): Boolean = {
    @tailrec
    def checkIfPetIsFriend(remainingPets: List[Pet], accumulatedPets: Set[Pet]): Boolean = {
      remainingPets match {
        case Nil => true
        case nextPet :: tl =>
          val isFriendsWithAllAccumulatedPets = accumulatedPets.forall(pet => pet.isFriend(nextPet) && nextPet.isFriend(pet))
          if (isFriendsWithAllAccumulatedPets) checkIfPetIsFriend(tl, accumulatedPets + nextPet)
          else false
      }
    }
    checkIfPetIsFriend(pets, Set.empty)
  }

}