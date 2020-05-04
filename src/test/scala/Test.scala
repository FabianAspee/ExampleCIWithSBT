<<<<<<< HEAD
package testset

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import prova.Main

class ProvaTest extends FunSuite with ShouldMatchers {

  test("Fallisci"){
    Main.combination(List("fra", "fab", "gia"), List("dio")).size should equal(4)
  }


package test.scala
import org.scalatest._
import prova.Main._

class Test extends FunSuite{
  test("Prova"){
    assert(isGordo("Fabian") == true)
  }
}

