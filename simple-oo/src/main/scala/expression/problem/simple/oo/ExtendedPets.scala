package expression.problem.simple.oo

object ExtendedPets {

  /** Defining a new data type */
  class Bird extends Pet {
    val price = 15.00
    def isFriend(pet: Pet): Boolean = pet match {
      case _: Dog => true
      case _: Cat => false
      case _: Fish => true
      case _: Bird => true
    }
    override def toString: String = "Bird"
  }

  class ExtendedDog extends Dog {
    override val price: Double = 25.00
    override def isFriend(pet: Pet): Boolean = pet match {
      case _: Dog => false
      case _: Cat => false
      case _: Fish => true
      case _: Bird => true
    }
  }

  class ExtendedCat extends Cat {
    override def isFriend(pet: Pet): Boolean = pet match {
      case _: Dog => false
      case _: Cat => false
      case _: Fish => true
      case _: Bird => true
    }
  }

  class ExtendedFish extends Fish {
    override def isFriend(pet: Pet): Boolean = pet match {
      case _: Dog => true
      case _: Cat => false
      case _: Fish => true
      case _: Bird => true
    }
  }

  /** Defining a new operation */
  // Cannot add a new operation to the Pet class without modifying it

}
