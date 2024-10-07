package ScalaFunctionalProgramming

object Concept2_AnonymousFunctions {
  def main(args: Array[String]): Unit = {

    // defining an anonymous function (LAMBDA)
    val doubler = (x : Int) => x * 2  // return type is inferred here
    val newDoubler : Int => Int = x => x * 2  // another way of defining lambda function
    println(s"doubler = ${doubler(10)}, newDoubler = ${newDoubler(24)}")

    // defining a multiple parameter anonymous function
    val adder : (Int, Int) => Int = (a, b) => a + b + 10
    println(s"adder(100,200) = ${adder(100, 200)}")

    val justDoSomething : () => Int = () => 3
    println(s"calling the justDoSomething without parentheses :- $justDoSomething") // returns function itself
    println(s"calling the justDoSomething with parentheses :- ${justDoSomething()}")
    // anonymous functions should always be called with parentheses

    // using curly braces with lambdas
    val stringToInt = {
      (aString : String) => {
        println("this is an anonymous function")
        aString.toInt + 100
      }
    }

    println(s"calling the stringToInt function :- ${stringToInt("10")}")

    val niceIncrement : Int => Int = _ + 1
    println(s"calling the niceIncrement anonymous function for the value 10 :- ${niceIncrement(10)}")

    val niceAdder : (Int, Int) => Int = _ + _  // we can use underscore notation if we are using the arguments only once
    println(s"calling the niceAdder anonymous function for the values 100 and 200 :- ${niceAdder(100, 200)}")

    // anonymous function which takes an argument and returns an anonymous function back
    val specialAdder : Int => Int => Int = a => b => a + b + 10
    println(s"calling the specialAdder anonymous function with two values :- ${specialAdder(100)(200)}")
  }
}
