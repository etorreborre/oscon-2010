package dsl

class InExampleSpec extends InExample {
  "This is ok" in {
	1 + 1
  }
  // is the same as
  "This is ok".in(1 + 1)
  forExample("this works") in {}
}