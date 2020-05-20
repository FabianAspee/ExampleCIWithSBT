package setting
import java.sql.Date

import utils.caseclass.CaseClassDB.{Giorno, Persona, Terminale, Zona}
import dbmanagment.operation.ImplicitCrudG.CrudPersona
import dbmanagment.operation.PersonaOperation

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object InsertDataBase {
  var id = 0
   def insertZona()= {
      val s = Zona("Giannis")
     // insert(s) onComplete { posts =>
     //   for (post <- posts) {id = post;println(post)}
     // }
  }
  def selectPersona()= {

    PersonaOperation.selectAll  onComplete { result =>
      for (post <- result) {println(post)}
    }
  }
  def insertPersona()= {
    val millis = System.currentTimeMillis
    val persona = Persona("Gianni","Speciale",new java.sql.Date(millis),"+393270176439",10,Some(id))
    // insert(persona) onComplete { result =>
    //   for (post <- result) {id = post;println(post)}
    // }
  }
  def insertTerminale()= {
    val persona = Terminale("Fabian",111)
     //insert(persona) onComplete { result =>
     //  for (post <- result) {
     //    id = post;println(post)
   //     insertPersona()
   //   }
   // }
  }
  def selectAllZona(): Unit ={
    val s = Zona
    // selectAll[Zona] onComplete { posts =>
    //   for (post <- posts) println(post)
    // }
  }
  def monadicJoin(): Unit ={
    val s = Zona
    PersonaOperation.monadicInnerJoin()
  }
  def removeAllZona(): Unit ={
    val s = List(Zona("",Some(110)),Zona("",Some(109)))
    // deleteAll(s) onComplete { posts =>
    //   for (post <- posts) println(post)
    // }
  }
  def selectFilter(): Unit ={
    PersonaOperation.filterByName("fabian")  onComplete { result =>
      for (post <- result) {println(post)}
    }
  }
  def selectZona(): Unit ={
    val s = Zona("",Some(id))
    //  select[Zona](id)  onComplete { posts =>
    //    for (post <- posts) println(post)
    //  }
  }
  def updateZona(): Unit ={
    val s = Zona("el mejor es Fabian :)",Some(id))
   //  update(s).onComplete {
   //    case Success(x) => println(x)
   //    case Failure(x) => println(x)
  //  }
  }
  def deleteZona(): Unit ={
    val s = Zona("",Some(id))
    // delete(s)  onComplete { posts =>
    //   for (post <- posts) println(post)
    // }
  }
}