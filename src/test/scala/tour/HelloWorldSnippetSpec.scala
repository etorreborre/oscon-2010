package tour

import org.specs._
import scala.xml._

class HelloWorldSnippetSpec extends SpecificationWithJUnit with HelloWorldSnippet {
  "the snippet must output a div element" >> {
	hello("Eric") must \\(<div/>)
  }
  "the snippet must have a 'class' attribute with a 'text' value" >> {
	hello("Eric") must \\(<div/>, "class" -> "text")
  }
  "the snippet must output the user name" >> {
	hello("Eric").flatMap(_.child) must contain(new Atom("Eric"))
  }
}
