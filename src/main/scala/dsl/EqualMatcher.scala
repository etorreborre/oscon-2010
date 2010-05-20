package dsl

abstract class Matcher[-T] 
class EqualMatcher[T](x: T) extends Matcher[T] { 
  def apply(y: =>T) = {
    val (a, b) = (x, y)
    (a == b, a + " is equal to " + b, a + " is not equal to " + b)
  }
}