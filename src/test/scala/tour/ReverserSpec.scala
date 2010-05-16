package tour

import org.specs._
import IncredibleStringReverser._

class ReverserSpec extends Specification {
  "a reversed empty string must be empty" in {
    reverse("") must_== ""  
  }
  "a reversed empty string must really *be empty*" in {
    reverse("") must be empty
  }
  "a reversed string must be reversed abc -> cba" in {
    reverse("abc") must be_==("cba")
  }
  "a longer reversed string must also be reversed. Woops!" in {
    reverse("abcdef") must be_==("xxxxx")
  }
}
