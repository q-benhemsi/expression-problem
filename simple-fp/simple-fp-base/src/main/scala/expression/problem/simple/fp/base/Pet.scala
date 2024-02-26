package expression.problem.simple.fp.base

import scala.annotation.tailrec

/** In an FP language a sealed trait is called a sum type (aka coproduct).
 * This page is very similar fo the non-extensible approach.
 * The main difference is that `Pet` defines no methods.
 * This is because methods belong to objects which are not a construct in FP languages. */
sealed trait Pet

case object Dog extends Pet
case object Cat extends Pet
case object Fish extends Pet

object Pet {

  def petPrice(pet: Pet): Double = pet match {
    case Dog => 20.00
    case Cat => 20.00
    case Fish => 12.00
  }

  def totalCost(pets: List[Pet]): Double = pets.map(petPrice).sum

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

}


