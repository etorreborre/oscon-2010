package dsl

trait TaggedSpecs {
  trait Tagged {
    def tag(t: String): this.type = this
  }
  class Spec extends Tagged {
	def include(other: Spec*): Spec = this
  }
  val slow = new Spec
  val fast = new Spec
  class BigSpec extends Spec {
	include(slow tag "slow", fast)  
  }
}
