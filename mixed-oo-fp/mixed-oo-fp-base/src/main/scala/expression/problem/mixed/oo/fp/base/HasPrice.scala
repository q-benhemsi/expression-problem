package expression.problem.mixed.oo.fp.base

trait HasPrice[PetType] {
  def price(pet: PetType): Double
}

object HasPrice {
  implicit val dogHasPrice: HasPrice[Dog.type] = new HasPrice[Dog.type] {
    def price(pet: Dog.type): Double = 20.00
  }
  implicit val catHasPrice: HasPrice[Cat.type] = new HasPrice[Cat.type] {
    def price(pet: Cat.type): Double = 20.00
  }
  implicit val fishHasPrice: HasPrice[Fish.type] = new HasPrice[Fish.type] {
    def price(pet: Fish.type): Double = 12.00
  }
}