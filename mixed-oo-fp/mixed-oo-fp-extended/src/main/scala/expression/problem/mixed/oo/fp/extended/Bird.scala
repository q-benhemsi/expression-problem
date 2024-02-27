package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._

case object Bird extends Pet

object BirdTCInstances {
  implicit val hasPriceInstance: HasPrice[Bird.type] = new HasPrice[Bird.type] {
    def price(pet: Bird.type): Double = 15.00
  }
  implicit val birdHasFriends: HasFriends[Bird.type] = new HasFriends[Bird.type] {
    def isFriend(pet1: Bird.type, pet2: Pet): Boolean = pet2 match {
      case Cat => false
      case Dog => true
      case Fish => true
      case Bird => true
    }
  }
}