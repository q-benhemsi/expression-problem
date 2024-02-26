package expression.problem.fp.typeclasses.extended

import expression.problem.fp.typeclasses.base.Pet

case object Bird

object BirdTCInstances {
  implicit val birdPetInstance: Pet[Bird.type] = new Pet[Bird.type] {
    def price(pet: Bird.type): Double = 15.00
  }
}
