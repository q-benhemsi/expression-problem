package expression.problem.simple.oo.base

class Cat extends Pet {
  val price = 20.00
  def isFriend(pet: Pet): Boolean = pet match {
    case _: Dog => false
    case _: Cat => false
    case _: Fish => true
  }
  override def toString: String = "Cat"
}
