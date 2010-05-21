package dsl

class Operators {
  class ExampleDesc(description: String) {
	def >>(e: =>Any): Example = new Example(description, e)
  }
  class Example(description: String, expectations: =>Any) {
	def >>(e: =>Any): Example = new Example(description, e)
  }
  "When I setup the system" >> {
	"And a customer is entered" >> {
	  "if he has a discount" >> {}
	  "if he doesn't have a discount" >> {}
	}
  }
  implicit def forExample(d: String): ExampleDesc = new ExampleDesc(d)
  
  /**
   * Fit-like table in Scala?
   * 
   *  | a | b | c |
   *  | 1 | 2 | 3 |
   *  | 2 | 2 | 4 |
   */
}