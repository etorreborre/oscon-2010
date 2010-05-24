package tour

object ExtendedFunctions extends ExtendedFunctions 
trait ExtendedFunctions {
  implicit def extend[A, B](f: Function[A, B]) = new ExtendedFunction(f)
}
/**
 * this class allows to use a function as if it was a partial function.
 *
 * It is especially useful when one want to overload a function with both functions and partial function
 * literals. This usually is an issue because of the way the compiler interprets function and 
 * partial function literals (see the Scala Language Specification, section 8.5). 
 *
 * The following specification shows the how to use it: 
 * <code>
 * 	class Test[T](val t: T) {
 *     def call[S](x: Function[T, S]): Option[S] = x.applySafely(t)
 *  }
 *  val test = new Test("hello")
 *  test call identity must beSome("hello")
 *  // this behaves like a partial function but is a function really
 *  test call { case s if s.size < 2 => "partial " + s } must beNone
 * </code>
 * 
 */
class ExtendedFunction[A, B](f: Function[A, B]) {
  def applySafely(a: =>A): Option[B] = {
	try {
	  Some(f(a))
	} catch {
	  case e: MatchError => None
	}
  }
}

import org.specs._
import ExtendedFunctions._

class extendedFunctionSpec extends SpecificationWithJUnit {
  "a function defined as a list of cases can have an applySafely method" >> {
	val f: PartialFunction[Int, String] = { case a if a > 0 => a.toString }
	"returning Some(value) if there's no MatchError" in {
	  f.applySafely(1) must beSome("1")
	}  
	"returning None in case of a MatchError" in {
	  f.applySafely(0) must be none;
	}  
	"rethrowing a match error if it isn't part of the function definition" in {
      val f2: Function[Int, String] = { case a => a match { case x if x > 0 => x.toString } }
	  f2.apply(0) must throwA[MatchError]
	}  
  }
  "a method can accept a function or a partial function" >> {
	class Test[T](val t: T) {
     def sub[S](x:Function[T, S]): Option[S] = x.applySafely(t)
    }
    val test = new Test("hello")
    test sub identity must beSome("hello")
    test sub { case s if s.size < 2 => "partial " + s } must beNone
  }
}