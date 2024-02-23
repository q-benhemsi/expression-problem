package expression.problem.fp.typeclasses

/** Pet typeclass. */
trait Pet[PetType] {
  def price(pet: PetType): Double
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

  def priceOfPet[PetType](pet: PetType)(implicit petInstance: Pet[PetType]): Double = petInstance.price(pet)

}
