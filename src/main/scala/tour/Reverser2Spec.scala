package tour

import org.specs._
import IncredibleStringReverser._

class Reverser2Spec extends Specification {
  "a reversed empty string" should {
	val reversed = reverse("")  
    "be empty" in {
      reversed must_== ""  
    }
    "really *be empty*" in {
      reversed must be empty
    }
  }
  "a reversed non-empty string" should {
	val reversed = reverse("abc")  
    "be reversed abc -> cba" in {
      reversed must be_==("cba")
    }
    "have the same size as the original string" in {
      reversed must have size(3)
    }
  }
}
