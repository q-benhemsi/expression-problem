package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base.{HasFriends, HasPrice, Pet, TCBox}

import scala.annotation.tailrec

case class ExtendedPetTypeclasses[PetType]()(
  implicit val hasPrice: HasPrice[PetType],
  val petFood: PetFood[PetType],
  val hasFriends: HasFriends[PetType]
)

object ExtendedPetTypeclasses {

  /** The `pets` argument is a list of `(Pet, TCBox[ExtendedPetTypeclasses])` pairs.
   * There are no methods defined in `Pet` so all the operations are contained in the `TCBox[ExtendedPetTypeclasses]`.
   * We need the `Pet` for the `hasFriends.isFriend` method.
   * There are no static guarantees that the `TCBox[ExtendedPetTypeclasses]` corresponds to the pet in its pair.
   * I.e. the following would compile, but lead to a runtime exception:
   * {{{
   * val pets = List((Dog, MkTCBox(Cat)(ExtendedPetTypeclasses())))
   * canBuyPets(pets)
   * }}} */
  def canBuyPets(pets: List[(Pet, TCBox[ExtendedPetTypeclasses])]): Boolean = {
    @tailrec
    def checkIfPetIsFriend(remainingPets: List[(Pet, TCBox[ExtendedPetTypeclasses])], accumulatedPets: Set[Pet]): Boolean = {
      remainingPets match {
        case Nil => true
        case (pet, extendedPetTC) :: tl =>
          val isFriendsWithAllAccumulatedPets = accumulatedPets.forall { accumulatedPet =>
            val isFriend1 = extendedPetTC.instance.hasFriends.isFriend(extendedPetTC.value, accumulatedPet)
            val accumulatedPetHasFriendsTC = pets.find(_._1 == accumulatedPet).get._2
            val isFriend2 = accumulatedPetHasFriendsTC.instance.hasFriends.isFriend(accumulatedPetHasFriendsTC.value, pet)
            isFriend1 && isFriend2
          }
          if (isFriendsWithAllAccumulatedPets) checkIfPetIsFriend(tl, accumulatedPets + pet)
          else false
      }
    }
    checkIfPetIsFriend(pets, Set.empty)
  }
}