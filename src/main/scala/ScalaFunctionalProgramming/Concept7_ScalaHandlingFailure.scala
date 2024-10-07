package ScalaFunctionalProgramming

import scala.util.{Failure, Success, Try}

object Concept7_ScalaHandlingFailure {
  def main(args: Array[String]): Unit = {

    def unsafeMethod() : String = throw new RuntimeException("NO STRING FOR U")

    // usually to handle exceptions we will use try/catch block like this
    val failure = try {
      val data = unsafeMethod()
    } catch {
      case ex : RuntimeException =>
        ex.toString + " Exception occurred"
    }
    println(failure)

    // instead of that we can use Try which will show the failure
    val potentialFailure = Try(unsafeMethod())
    println(potentialFailure)
    println(potentialFailure.isSuccess)
    println(potentialFailure.isFailure)

    def backupMethod() : String = "A valid result"
    val fallBackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
    println(fallBackTry)

    // use Try if you feel your code might return exceptions
    // Try also has map, filter and flatMap

    val aFailure = Failure(new RuntimeException("This is a failure"))
    val aSuccess = Success(10)
    println(aSuccess.map(_ * 2))
    println(aSuccess.flatMap(x => Success(x * 10)))
    println(aSuccess.filter(_ % 2 > 30))
  }
}
