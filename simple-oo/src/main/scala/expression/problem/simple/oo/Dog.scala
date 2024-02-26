package expression.problem.simple.oo

class Dog extends Pet {
  val price = 20.00
  def isFriend(pet: Pet): Boolean = pet match {
    case _: Dog => false
    case _: Cat => false
    case _: Fish => true
  }
  override def toString: String = "Dog"
}

