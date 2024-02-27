package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base.Pet

/** Group together all the typeclasses we need in the PetShop application. */
case class ExtendedPetTypeclasses[PetType]()(
  implicit val pet: Pet[PetType],
  val petFood: PetFood[PetType]
)