package scala.macros.tests
package helpers

import org.junit.Assume._

trait TypecheckHelpers {
  def assertTypecheckError(error: String, code: String): Unit = {
    assumeTrue("assertTypecheckError is not yet implemented in Dotty", false)
    ???
  }
}
