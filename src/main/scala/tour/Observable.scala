package tour

/**
 * A simple Observable-Observer pattern implementation
 */
trait Observable {
  private var observers: List[Observer] = Nil
  def add(o: Observer) = observers = o :: observers
  def changed(event: String) = observers foreach (_.notify(event))
}
trait Observer {
  def notify(event: String)
}