package ScalaFunctionalProgramming

import scala.annotation.tailrec

object Concept3_HigherOrderAndCurriedFunctions {
  def main(args: Array[String]): Unit = {

    @tailrec
    def nTimes(f : Int => Int, n : Int, x : Int) : Int =
      if (n == 0) x
      else nTimes(f,n - 1, f(x))

    val plusOne = (x : Int) => x + 1
    println(s"The return value from the nTimes function is :- ${nTimes(plusOne, 10, 1)}")

    def nTimesBetter(f : Int => Int, n : Int) : (Int => Int) =
      if (n == 0) (x : Int) => x
      else (x : Int) => nTimesBetter(f, n -1)(f(x))

    val increment1 = nTimesBetter(plusOne, 10)
    println(s"The return value from the nTimesBetter function is :- ${increment1(1)}")

    // functions with multiple parameter lists
    def curriedFormatter(c : String)(x : Double) : String = c.format(x)

    val standardFormat : (Double => String) = curriedFormatter("%4.2f")
    val preciseFormat : (Double => String) = curriedFormatter("%10.8f")
    println(standardFormat(Math.PI))
    println(preciseFormat(Math.PI))
  }
}
