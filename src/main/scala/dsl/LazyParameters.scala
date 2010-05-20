package dsl

/**
 * This trait can be used to allow some function to be called with varargs, with
 * values being evaluated lazily:<code>
 * 
 * def method[T](values: LazyParameter[T]*) = {
 *	values.toStream // use the toStream method to consume the values lazily
 * }
 * // usage  
 * method(exp1, exp2, exp3)  
 * </code>
 * Note that the values are really evaluated once, unlike a by-name parameter.
 * @see org.specs.util.lazyParamSpec
 */ 

trait LazyParameters {
  /** transform a value to a zero-arg function returning that value */
  implicit def toLazyParameter[T](value: =>T) = new LazyParameter(() => value)
  def method[T](params: LazyParameter[T]*) = params.toStream
  method(1., 2., math.pow(100, 100))
}
/** class holding a value to be evaluated lazily */
class LazyParameter[T](value: ()=>T) {
  lazy val v = value()
  def apply() = v
}

