package expression.problem.mixed.oo.fp.base

class Dog extends Pet {
  val price: Double = 20.00
  override def toString: String = "Dog"
}

object Dog {
  implicit val dogHasFriends: HasFriends[Dog] = new HasFriends[Dog] {
    def isFriend(pet1: Dog, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => false
      case _: Fish => true
    }
  }
}