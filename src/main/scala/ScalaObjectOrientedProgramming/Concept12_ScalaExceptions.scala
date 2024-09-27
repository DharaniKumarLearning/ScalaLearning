package ScalaObjectOrientedProgramming

object Concept12_ScalaExceptions {
  def main(args: Array[String]): Unit = {

    val x : String = null
    // println(x.length) // java.lang.NullPointerException
    // the above statement will cause NullPointerException as we are calling length function on a null value

    // throwing and catching exceptions
    // We can throw exception using throw new <exception_name>
    // Exceptions are instances of classes

    // val aWeirdValue = throw new NullPointerException

    // throwable classes extend the Throwable class
    // Exception and Error are the major Throwable sub types

    def getInt(withExceptions : Boolean) : Int =
      if (withExceptions) throw new RuntimeException("No Int value for u")
      else 42

    try {
      getInt(true)
    } catch {
      case e : RuntimeException =>
        println(s"caught the run time exception $e")
    } finally { // finally is optional and also doesn't influence the return type of the try/catch block
      println("finally")
    }

    // defining our own exceptions
    class MyException extends Exception
    val myException = new MyException
    // throw myException // throwing our own exception

    // Creating an OutOfMemoryError
    // val array = new Array[Int](Int.MaxValue)  // Exception in thread "main" java.lang.OutOfMemoryError

    // Creating a StackOverflowError
    def infiniteLoop :  Int = 1 + infiniteLoop
    // println(infiniteLoop) // Exception in thread "main" java.lang.StackOverflowError

    class OverFlowException extends Exception
    class UnderFlowException extends Exception
    class MathCalculationException(exc : String) extends RuntimeException(exc)

    object PocketCalculator {
      def add(x : Int, y : Int) : Long =
        val result = x.toLong + y.toLong
        if (result > Int.MaxValue) throw new OverFlowException
        else if(result < Int.MinValue) throw new UnderFlowException
        else result

      def divide(x : Int, y : Int) : Int =
        if ( y == 0) throw new MathCalculationException("Stupid how can u divide with zero")
        else x / y
    }

    val addition = PocketCalculator.add(10, 10)
    println(s"The result from calling add function is :- ${addition}")

    val division = PocketCalculator.divide(10, 2)
    println(s"The result from calling divide function is :- ${division}")
  }
}
