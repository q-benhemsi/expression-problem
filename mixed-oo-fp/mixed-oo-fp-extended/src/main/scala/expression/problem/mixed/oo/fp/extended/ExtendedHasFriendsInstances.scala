package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._

object ExtendedHasFriendsInstances {

  implicit val dogHasFriends: HasFriends[Dog.type] = new HasFriends[Dog.type] {
    def isFriend(pet1: Dog.type, pet2: Pet): Boolean = pet2 match {
      case Cat => false
      case Dog => false
      case Fish => true
      case Bird => true
    }
  }

  implicit val catHasFriends: HasFriends[Cat.type] = new HasFriends[Cat.type] {
    def isFriend(pet1: Cat.type, pet2: Pet): Boolean = pet2 match {
      case Cat => false
      case Dog => false
      case Fish => true
      case Bird => true
    }
  }

  implicit val fishHasFriends: HasFriends[Fish.type] = new HasFriends[Fish.type] {
    def isFriend(pet1: Fish.type, pet2: Pet): Boolean = pet2 match {
      case Cat => false
      case Dog => true
      case Fish => true
      case Bird => true
    }
  }

}
