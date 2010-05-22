package dsl
import org.specs._

class ResultSpec extends Specification {
  val list: List[Int] = Nil
  
  list must have size(3)
  list must be empty
  
  list must have size(2) or have size(3)

  (((list must have).size(2)).or(have)).size(3)

    list must have size(2) and have size(3)

  ((list must have).size(3)).or(be).empty
  
}