package dsl

trait PonyResult {
  /**
   *  how to write:
   *  I want a pony
   *  ??
   */  
  /**
   *  2 solutions:
   *  
   *  I.want(a.pony) => ScalaTest
   *  (I.want(a)).pony) => specs
   */
  // 
	
  val I = 1 
  trait Word; class AWord extends Word
  val a = new AWord
  
  class Expectable {
	def want(a: Word) = new Result
  }
  class Result {
	def pony = {}
  }
  implicit def theValue[T](i: T): Expectable = new Expectable
  I want a pony
}