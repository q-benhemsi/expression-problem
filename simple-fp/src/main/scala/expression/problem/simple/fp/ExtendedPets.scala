package expression.problem.simple.fp

/** In this file we attempt to extend [[Pet]] defined in `DefaultPets` with more data types and operations. */
object ExtendedPets {

  /** Defining a new data type. */
  // case object Bird extends Pet
  // This does not compile because `Pet` is sealed and we cannot extend it outside of its file.

  /** Defining a new operation. */
  def petFood(pet: Pet): String = pet match {
    case Dog => "dog-food"
    case Cat => "cat-food"
    case Fish => "fish-food"
  }

}
