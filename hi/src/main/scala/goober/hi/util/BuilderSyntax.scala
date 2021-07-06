package goober.hi.util

object BuilderSyntax {
  implicit class BuilderSyntax[B](private val self: B) extends AnyVal {
    def ifSome[A](value: Option[A])(f: B ⇒ A ⇒ B): B =
      value.fold(self)(f(self))
  }
}