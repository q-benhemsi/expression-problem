package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base._

object ExtendedPets {

  /** Defining a new data type. */
  object Bird

  implicit val birdPetInstance: Pet[Bird.type] = new Pet[Bird.type] {
    override def price(pet: Bird.type): Double = 50.0
  }

  /** Defining a new operation. */
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
  }

}
