package testset

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import prova.Main

class ProvaTest extends FunSuite with ShouldMatchers {

  test("Fallisci"){
    Main.combination(List("fra", "fab", "gia"), List("dio")).size should equal(3)
  }
}
