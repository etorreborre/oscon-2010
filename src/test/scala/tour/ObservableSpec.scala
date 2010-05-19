package tour

import org.specs._
import org.specs.mock._

class ObservableSpec extends Specification with Mockito {
  val observer = mock[Observer]
  val observable = new Observable { add(observer) }
  "An observable must notify its observers when changed" >> {
	observable.changed("event")
	there was one(observer).notify("event")
  }
  "An observable must notify its observers with all events when changed" >> {
	observable.changed("event1")
	observable.changed("event2")
	there was two(observer).notify(startWith("event"))
  }
}