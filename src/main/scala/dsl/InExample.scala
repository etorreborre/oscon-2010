package dsl

object InExample extends InExample
trait InExample {
  class Example(description: String) {
	def in(expectations: =>Any) = expectations
	def tag(t: String) = ()
  }
  "this is a ".tag("really?")
  implicit def forExample(d: String): Example = new Example(d)
}