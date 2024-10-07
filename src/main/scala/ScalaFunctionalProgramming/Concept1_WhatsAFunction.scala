package ScalaFunctionalProgramming

object Concept1_WhatsAFunction {
  def main(args: Array[String]): Unit = {
    // the main objective of functional programming is to use functions as first class elements

    val doubler = new MyFunction[Int,Int] {
      override def apply(element : Int) : Int = element * 2
    }

    println(doubler(10))  // calling doubler as a function

    // Scala actually has function types
    val stringToIntConverter = new Function1[String, Int] {
      override def apply(element : String) : Int = element.toInt
    }

    println(stringToIntConverter("30") + 4)

    // Function2[Int, Int, Int] -- first 2 values are parameters and the last value is return type
    val adder = new Function2[Int, Int, Int] {
      override def apply(a: Int, b: Int): Int = a + b
    }

    println(adder(100, 200))

    val tripleSum : (Int, Int, Int) => Int = new ((Int, Int, Int) => Int) { // syntactic sugar to define Function3
      override def apply(a: Int, b: Int, c: Int): Int = a + b + c
    }

    println(tripleSum(100, 200, 300))
    // All Scala functions are objects deriving from Function1, Function2 .. Function22

    // define a function that takes two strings and concatenates them
    val stringConcatenation = new ((String, String) => String) {
      override def apply(a : String, b : String) = a + b
    }

    println(stringConcatenation("Hello, ", "World!"))

    // define a function which takes an Int and returns another function which takes an int and returns int
    val anotherFunction = new (Int => Int => Int) {
      override def apply(a: Int): Int => Int = new (Int => Int) {
        override def apply(b: Int): Int = a + b + 10
      }
    }

    val firstCall = anotherFunction(10)
    val secondCall = firstCall(20)
    println(secondCall)
    println(anotherFunction(100)(200))  // different way of calling anotherFunction function
    // curried function

    // higher order functions are functions that can take functions as arguments and can return functions
  }

  private trait MyFunction[A, B] {
    def apply(element : A) : B
  }
}
