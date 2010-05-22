package dsl

trait ClassManifests extends org.specs.Specification {
//  class FailureException extends Exception
  // you can avoid writing throwing throwA(classOf[FailureException])
  //{ 1 must_== 2 } must throwA[FailureException]
}
trait NewThrow {
  trait Matcher[T] { def apply(v: =>T): Boolean }
  import scala.reflect._
  def throwA[T](implicit m: ClassManifest[T]) = new Matcher[Any] {
	def apply(v: =>Any): Boolean = {
      try {
    	  
      } catch { case e => return e.getClass == m.erasure }
      true
	} 
  }
  def expectationsAre(a: Any) = ()
//  var hasNestedExamples = true
  
//  def in[T](e: =>T)(implicit m: ClassManifest[T]) = {
//    expectationsAre(e)
//    if (m.erasure == this.getClass)
//      hasNestedExamples = true
//    this
//  }
  
}