package expression.problem.simple.oo.base

class Fish extends Pet {
  val price = 12.00
  def isFriend(pet: Pet): Boolean = pet match {
    case _: Dog => true
    case _: Cat => false
    case _: Fish => true
  }
  override def toString: String = "Fish"
}

