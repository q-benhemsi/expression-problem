package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base.{Cat, Dog, Fish}

trait PetFood[PetType] {
  def food(pet: PetType): String
}

object PetFood {
  implicit val dogFoodInstance: PetFood[Dog.type] = new PetFood[Dog.type] {
    override def food(pet: Dog.type): String = "dog-food"
  }
  implicit val catFoodInstance: PetFood[Cat.type] = new PetFood[Cat.type] {
    override def food(pet: Cat.type): String = "cat-food"
  }
  implicit val fishFoodInstance: PetFood[Fish.type] = new PetFood[Fish.type] {
    override def food(pet: Fish.type): String = "fish-food"
  }
  implicit val birdFoodInstance: PetFood[Bird.type] = new PetFood[Bird.type] {
    override def food(pet: Bird.type): String = "bird-food"
  }
}
