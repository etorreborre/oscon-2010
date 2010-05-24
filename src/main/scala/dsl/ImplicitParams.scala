package dsl
import org.specs._
import org.scalacheck.Prop._
import tour.IncredibleStringReverser._
trait ImplicitParams {
  class Reverser4Spec extends SpecificationWithJUnit with ScalaCheck {
	"The default configuration can be overriden" in {
	  forAll { (s: String) => reverse(reverse(s)) == s } must pass(display(minTestsOk -> 10))
	}
  }
}