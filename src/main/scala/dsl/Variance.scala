package dsl

trait Variance {
  trait Matcher[-T] { def apply(y: =>T): Boolean }
  class EqualMatcher(x: Any) extends Matcher[Any] { 
	def apply(y: =>Any) = x == y
  }
  class HelloMatcher extends Matcher[String] { 
	def apply(x: =>String) = x == "hello"
  }
  val beHello = new HelloMatcher
  val equalToHello = new EqualMatcher("hello")
  "hello" must beHello
  "hello" must equalToHello

  class Expectation[T](t: =>T) {
    def must(m: =>Matcher[T]) = m.apply(t)
  }
  implicit def theValue[T](t: T): Expectation[T] = new Expectation(t)
}