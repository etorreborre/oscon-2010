package tour
import scala.xml._
trait HelloWorldSnippet {
  def hello(s: String): Elem = <div class="text">Hello {s}</div>
}