package dsl
import org.specs._
import org.scalacheck.Prop._
import tour.IncredibleStringReverser._

class Reverser4Spec extends SpecificationWithJUnit with ScalaCheck {
//  object set extends Parameters(setParams(Nil)) {
//    def apply(p: (Symbol, Int)*) = new Parameters(setParams(p))
//  }
//
//  /**
//    * default parameters. Uses ScalaCheck default values and doesn't print anything to the console
//    */
//   implicit def defaultParameters = new Parameters(setParams(Nil))
//  def pass(implicit params: Parameters) = new Matcher[Prop](){
//    def apply(p: => Prop) = checkProperty(p)(params)
//  }

  val prop = forAll { (s: String) => reverse(reverse(s)) == s } 
  "The default configuration doesn't display anything" in {
	prop must pass
  }
  "The default configuration can be overriden with other params" in {
	prop must pass(set(minTestsOk -> 3))
  }
  "The default configuration can be overriden to display tests" in {
	prop must pass(display(minTestsOk -> 3))
  }
}
