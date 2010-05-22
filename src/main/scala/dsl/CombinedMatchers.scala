package dsl

trait Combined {
  trait Matcher[-T] {
    def apply(y: =>T): (Boolean, String, String)
    def not: Matcher[T]
    def when(condition: =>Boolean): Matcher[T]
    def unless(condition: =>Boolean): Matcher[T]
    def orSkip: Matcher[T]
    def or[S <: T](m: Matcher[S]): Matcher[S]
    def xor[S <: T](m: Matcher[S]): Matcher[S]
    def and[S <: T](m: Matcher[S]): Matcher[S]
    def ^^[S<: T, U](f: S => U): Matcher[U]
    def toSeq: Matcher[Seq[T]]
  } 
}