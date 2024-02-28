package expression.problem.non.extensible

import scala.annotation.tailrec

sealed trait Pet {
  def price: Double
}

case object Dog extends Pet {
  val price: Double = 20.00
}

case object Cat extends Pet {
  val price: Double = 20.00
}

case object Fish extends Pet {
  val price: Double = 12.00
}

object Pet {
  /** This function returns a Boolean of whether pet1 likes pet2.
   * It is non-symmetric, e.g. `areFriends(Cat, Fish) = true` because cats will happily eat fish, but `areFriends(Fish, Cat) = false`
   * because fish don't like being eaten. */
  def areFriends(pet1: Pet, pet2: Pet): Boolean = (pet1, pet2) match {
    case (Dog, Dog) => false
    case (Dog, Cat) => false
    case (Dog, Fish) => true
    case (Cat, Dog) => false
    case (Cat, Cat) => false
    case (Cat, Fish) => true
    case (Fish, Dog) => true
    case (Fish, Cat) => false
    case (Fish, Fish) => true
  }

  /** `pets` is the list of pets that the customer wants to buy.
   * This checks that all the pets in that list are friendly towards each other using the `areFriends` function.
   * No responsible pet shop will sell a customer two pets that do not get on with each other! */
  def canBuyPets(pets: List[Pet]): Boolean = {
    @tailrec
    def checkIfPetIsFriend(remainingPets: List[Pet], accumulatedPets: Set[Pet]): Boolean = {
      remainingPets match {
        case Nil => true
        case nextPet :: tl =>
          val isFriendsWithAllAccumulatedPets = accumulatedPets.forall(pet => areFriends(nextPet, pet) && areFriends(pet, nextPet))
          if (isFriendsWithAllAccumulatedPets) checkIfPetIsFriend(tl, accumulatedPets + nextPet)
          else false
      }
    }
    checkIfPetIsFriend(pets, Set.empty)
  }

  def totalCost(pets: List[Pet]): Double = pets.map(_.price).sum

}