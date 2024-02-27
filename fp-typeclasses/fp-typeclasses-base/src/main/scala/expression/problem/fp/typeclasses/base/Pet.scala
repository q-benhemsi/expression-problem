package expression.problem.fp.typeclasses.base

/** Pet typeclass. */
trait Pet[PetType] {
  def price(pet: PetType): Double

  // We cannot define the isFriend method because we don't have a common type shared by all pets
  // def isFriend(pet: PetType, otherPet: ??): Boolean
}

object Pet {

  implicit val dogInstance: Pet[Dog.type] = new Pet[Dog.type] {
    def price(dog: Dog.type): Double = 20.00
  }

  implicit val catInstance: Pet[Cat.type] = new Pet[Cat.type] {
    def price(cat: Cat.type): Double = 20.00
  }

  implicit val fishInstance: Pet[Fish.type] = new Pet[Fish.type] {
    def price(fish: Fish.type): Double = 12.00
  }

}
