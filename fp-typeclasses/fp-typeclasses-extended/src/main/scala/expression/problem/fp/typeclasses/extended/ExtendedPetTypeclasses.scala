package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base.Pet

case class ExtendedPetTypeclasses[PetType]()(
  implicit val pet: Pet[PetType],
  val petFood: PetFood[PetType]
)