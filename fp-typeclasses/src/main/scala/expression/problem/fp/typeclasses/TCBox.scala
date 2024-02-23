package expression.problem.fp.typeclasses

/** Code take from https://pjrt.medium.com/existential-types-in-scala-6321f19c4a57. */
trait TCBox[Typeclass[_]] {
  type T
  val value: T
  val instance: Typeclass[T]
}

case class MkTCBox[Typeclass[_], A](value: A)(implicit val instance: Typeclass[A]) extends TCBox[Typeclass] {
  type T = A
}
