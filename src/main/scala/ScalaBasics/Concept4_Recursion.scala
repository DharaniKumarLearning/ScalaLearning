package ScalaBasics

import scala.annotation.tailrec

object Concept4_Recursion {
  def main(args: Array[String]): Unit = {

    def factorial(n : Int) : Int = {
      if(n == 1) 1
      else {
        println(s"Computing factorial of $n -- I first need factorial of ${n - 1}")
        val result = n * factorial(n - 1)
        println(s"Computed factorial of $n and the result is :- $result")
        result
      }
    }

    println(s"The factorial of the number 6 is :- ${factorial(6)}")
    // println(s"The factorial of the number 10000 is :- ${factorial(10000)}")
    // The above println statement throws the Exception in thread "main" java.lang.StackOverflowError
    // this is the mainly because the stacks got filled up with memory

    def goodFactorial(n : Int) : BigInt = {
      @tailrec
      def factorialHelper(x : Int, accumulator : BigInt) : BigInt = {  // this is tail recursion
        if(x <= 1) accumulator
        else {
          println(s"Computing factorial of $x which is $accumulator")
          factorialHelper(x - 1, x * accumulator)  // this syntax reuses the stack frame
        }
      }
      factorialHelper(n, 1)
    }

    println(s"The factorial of the number 100 is :- ${goodFactorial(100)}")

    def stringConcatenation(aString : String, n : Int) : String = {
      @tailrec
      def concatenationHelper(s : String, n : Int, accumulator : String) : String = {
        if(n == 0) accumulator
        else concatenationHelper(s, n - 1, s + accumulator)
      }
      concatenationHelper(aString, n, "")
    }

    println(s"Calling the stringConcatenation function :- ${stringConcatenation("World", 5)}")

    def isPrime(n : Int) : Boolean = {
      @tailrec
      def isPrimeTailRec(t : Int, isStillPrime : Boolean) : Boolean = {
        if(!isStillPrime) false
        else if (t <= 1) true
        else isPrimeTailRec(t - 1, n % t != 0)
      }
      isPrimeTailRec(n / 2, true)
    }

    println(s"Checking whether the number 173 is a prime or not using tail rec :- ${isPrime(173)}")
    println(s"Checking whether the number 177 is a prime or not using tail rec :- ${isPrime(177)}")

    // fibonacci series :- 0 1 1 2 3 5 8 13 21 34 55
    def fibonacci(n : Int) : Int = {
      @tailrec
      def fibonacciTailRec(i : Int, last : Int, nextToLast : Int) : Int = {
        if (i >= n) last
        else fibonacciTailRec(i + 1, last + nextToLast, last)
      }
  
      if(n <= 2) 2
      else fibonacciTailRec(3, 1, 1)
    }

    println(s"The 10th fibonacci number is :- ${fibonacci(10)}")
  }
}
