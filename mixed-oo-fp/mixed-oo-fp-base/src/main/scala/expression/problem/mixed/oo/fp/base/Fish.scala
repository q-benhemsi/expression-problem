package expression.problem.mixed.oo.fp.base

class Fish extends Pet {
  val price: Double = 12.00
  override def toString: String = "Fish"
}

object Fish {
  implicit val fishHasFriends: HasFriends[Fish] = new HasFriends[Fish] {
    def isFriend(pet1: Fish, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => true
      case _: Fish => true
    }
  }
}