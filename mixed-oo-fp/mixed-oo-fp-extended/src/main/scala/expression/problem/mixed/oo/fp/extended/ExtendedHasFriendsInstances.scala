package expression.problem.mixed.oo.fp.extended

import expression.problem.mixed.oo.fp.base._

object ExtendedHasFriendsInstances {

  implicit val dogHasFriends: HasFriends[Dog] = new HasFriends[Dog] {
    def isFriend(pet1: Dog, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => false
      case _: Fish => true
      case _: Bird => true
    }
  }

  implicit val catHasFriends: HasFriends[Cat] = new HasFriends[Cat] {
    def isFriend(pet1: Cat, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => false
      case _: Fish => true
      case _: Bird => true
    }
  }

  implicit val fishHasFriends: HasFriends[Fish] = new HasFriends[Fish] {
    def isFriend(pet1: Fish, pet2: Pet): Boolean = pet2 match {
      case _: Cat => false
      case _: Dog => true
      case _: Fish => true
      case _: Bird => true
    }
  }

}
