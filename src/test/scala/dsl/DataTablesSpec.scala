package dsl
import org.specs._
import org.specs.util._

class DataTablesSpec extends Specification with DataTables {
  "lots of examples" >> {
	 "a" | "b" | "a + b" |
	  1  !  2  !    3    |
	  2  !  2  !    4    |
	  2  !  3  !    4    |> { (a, b, c) =>
	   a + b must_== c
	 }
  }
}