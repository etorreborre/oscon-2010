package dsl


trait InExample2 {
  class ExampleDesc(description: String) {
	def in(e: =>Any): Example = new Example(description, e)
  }
  class Example(description: String, expectations: =>Any)
  implicit def forExample(d: String): ExampleDesc = new ExampleDesc(d)
  
  "This will not explode" in error("boom")

  class Matcher[-T] { def apply(t: => T) = () }
  class Expectation[T](t: =>T) {
    def must(m: =>Matcher[T]) = m.apply(t)
  }
  implicit def theValue[T](t: T): Expectation[T] = new Expectation(t)
  val notExplode = new Matcher[Any]
  
  { error("boom"); () } must notExplode
  
}