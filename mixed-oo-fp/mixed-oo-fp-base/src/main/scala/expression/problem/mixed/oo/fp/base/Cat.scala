package expression.problem.mixed.oo.fp.base

class Cat extends Pet {
  val price: Double = 20.00
  override def toString: String = "Cat"
}

object Cat {
  implicit val catHasFriends: HasFriends[Cat] = new HasFriends[Cat] {
    def isFriend(pet1: Cat, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => false
      case _: Fish => true
    }
  }
}