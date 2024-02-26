package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._

class Bird extends Pet {
  val price: Double = 15.00
  override def toString: String = "Bird"
}

object Bird {
  implicit val birdHasFriends: HasFriends[Bird] = new HasFriends[Bird] {
    def isFriend(pet1: Bird, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => true
      case _: Fish => true
      case _: Bird => true
    }
  }
}