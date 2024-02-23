package expression.problem.non.extensible

import scala.annotation.tailrec

sealed trait Pet {
  def food: String
}

object Dog extends Pet {
  val food: String = "dog-food"

  override def toString: String = "Dog"
}

object Cat extends Pet {
  val food: String = "cat-food"

  override def toString: String = "Cat"
}

object Fish extends Pet {
  val food: String = "fish-food"

  override def toString: String = "Fish"
}

object Pet {
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

  def foodsToBuy(pets: List[Pet]): List[String] = pets.map(_.food)

}