package tour
import org.specs._
import IncredibleStringReverser._
import org.scalacheck._
import org.scalacheck.Prop.classify

class Reverser3Spec extends SpecificationWithJUnit with ScalaCheck with Sugar {
  "reverse must preserve the length of a string" verifies { s: String =>	 
    reverse(s).size == s.size 
  }
  "reverse applied twice must return the original string" verifies { s: String =>	 
    reverse(reverse(s)) == s 
  }
  "reverse 2 concatenated strings must return the reversed second string\n" + 
  "concatenated with the reverse of the first one" verifies { (s1: String, s2: String) =>	 
    reverse(s1 + s2) == reverse(s2) + reverse(s1) 
  }
  def center(s: String): Char = s(s.size / 2)
  implicit def simpleStrings: Arbitrary[String] = Arbitrary {
    for { l <- Gen.listOfN(4, Gen.oneOf('a', 'b', 'c')) } yield l.mkString
  }
  "keep the same 'center' character - Woops!" verifies { s: String =>
  new Exception("").printStackTrace
    s.isEmpty || (center(s.reverse) must_== center(s)) 
  }
}