package dsl
import org.specs._
import org.specs.util.TimeConversions._
import org.specs.util.Duration

class ImplicitDefExamplesSpec extends Specification with Sugar {
  "This is true" in { true must beTrue }
  3.seconds
  3 seconds
  
  3 times { i => println(i) }
  
  3.pp + 1 // print and pass
  1 aka "The number one" must_== 1
}