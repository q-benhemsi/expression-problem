package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base.{Cat, Dog, Fish}

trait PetFood[PetType] {
  def food(pet: PetType): String
}

object PetFood {
  implicit val dogFoodInstance: PetFood[Dog] = new PetFood[Dog] {
    override def food(pet: Dog): String = "dog-food"
  }
  implicit val catFoodInstance: PetFood[Cat] = new PetFood[Cat] {
    override def food(pet: Cat): String = "cat-food"
  }
  implicit val fishFoodInstance: PetFood[Fish] = new PetFood[Fish] {
    override def food(pet: Fish): String = "fish-food"
  }
  implicit val birdFoodInstance: PetFood[Bird] = new PetFood[Bird] {
    override def food(pet: Bird): String = "bird-food"
  }
}
