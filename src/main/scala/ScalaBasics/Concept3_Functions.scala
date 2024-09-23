package ScalaBasics

import scala.annotation.tailrec

object Concept3_Functions {
  def main(args: Array[String]): Unit = {

    def aFunction(a : String, b : Int) : String = {  // for normal functions we can ignore the return type
      a + ", " + b.toString
    }

    println(s"The return value from the aFunction is :- ${aFunction("Hello", 10)}")

    def aParameterLessFunction() : Int = 42
    println(s"Calling the aParameterLessFunction function :- ${aParameterLessFunction()}")

    def aRepeatedFunction(aString : String, aInt : Int) : String = {  // for recursive function return type is mandatory
      if(aInt == 1) aString
      else aString + aRepeatedFunction(aString, aInt - 1)
    }

    println(s"The return value from the recursive function is :- ${aRepeatedFunction("Hello", 4)}")

    // When you need loops in functional programming language use recursion

    def aFunctionWithSideEffects(aString : String) : Unit = {
      println(s"Hello $aString")
    }

    println(s"The return type from aFunctionWithSideEffects is :- ${aFunctionWithSideEffects("Ram")}")

    def aBigFunction(n : Int) : Int = {
      def aSmallerFunction(a : Int, b : Int) : Int = a + b
      aSmallerFunction(n, n - 1)
    }

    println(s"Calling the aBigFunction :- ${aBigFunction(10)}")

    def aGreetFunction(name : String, age : Int) : String = {
      s"Hi, my name is $name and I am $age years old"
    }

    println(s"The return value from the aGreetFunction function is :- ${aGreetFunction("Mincy", 4)}")

    @tailrec
    def factorial(n : Int, v : Int) : Int = {
      if(n == 1) v
      else factorial(n - 1, n * v)
    }

    println(s"The factorial of the number 6 is :- ${factorial(6, 1)}")

    def fibonacci(n : Int) : Int = {
      if(n <= 2) 1
      else {
        println(s"The value of n is :- $n")
        fibonacci(n - 1) + fibonacci(n - 2)
      }
    }

    println(s"The 20th fibonacci number is :- ${fibonacci(20)}")

    def isPrime(n : Int) : Boolean = {
      @tailrec
      def isPrimeUntil(t : Int) : Boolean = {
        if (t <= 1) true
        else n % t != 0 && isPrimeUntil(t - 1)
      }

      isPrimeUntil(n / 2)
    }

    println(s"Checking whether the number 173 is a prime or not :- ${isPrime(173)}")
    println(s"Checking whether the number 177 is a prime or not :- ${isPrime(177)}")

  }
}
