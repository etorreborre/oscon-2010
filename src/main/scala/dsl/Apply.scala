package dsl
import org.specs._
import org.specs.specification._

trait Apply {
  def deleteUsersTable = ()
  def inDatabaseSession(a: =>Any) = a
  
  object DBContext extends Specification {
    val setup = new SpecContext {
      // clean the DB
      beforeExample(deleteUsersTable)
      // make sure that each example expectations run inside a database session
      aroundExpectations(inDatabaseSession(_)) 
    }
  }
  object RepositorySpecification extends Specification {
    // equivalent to: DBContext.setup.apply(this)    
	DBContext.setup(this)
    "A Users repository" can {
      // ...
    }
  }
}