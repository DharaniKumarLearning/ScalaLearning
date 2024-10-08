package ScalaBasics

import scala.util.Random

object Concept8_ScalaPatternMatching {
  def main(args: Array[String]): Unit = {

    // Pattern matching is switch statement on steroids
    val r = new Random
    val x = r.nextInt(10)
    val description = x match {
      case 1 => s"the one"
      case 2 => "double or nothing"
      case 3 => "third time is the charm"
      case _ => "something else" // _ = WILD_CARD which can match anything
    }

    println(s"$x -> $description")

    case class Person(name : String, age : Int)
    val bob = Person("Bob", 30)

    // Pattern matching can be used to decompose values
    // In the below code we are accessing the name and age with the help of pattern matching

    val greeting = bob match {
      case Person(n, a) if a <= 20 => s"Hi My name is $n and I can't drink beer"  // we can have if guards like this
      case Person(n, a) => s"Hi My name is $n and I am $a years old"
      case _ => "I don't know how I am"
    }

    println(greeting)

    /*
      1. cases are matched in order
      2. What if no cases match => we get MatchError
      3. the type of the match expression is unified type of all the types in all the cases
    */

    // We can have types in pattern matching

    val unknown : Any = 'a'
    val unknownMatch = unknown match {
      case s : String => "you created a string variable"
      case d : Double => "you created a double variable"
      case i : Int => "you created an Int variable"
      case _ => "I don't know what u created"
    }

    println(s"unknownMatch = $unknownMatch")

    val standardList = List(1,2,3,42)
    val standardListPattern = standardList match {
      case List(1,_,_,_) | List(1,_*) | 1 :: List(2,3,42) => "the list matches"  // we can have multiple conditions as well
      case _ => "the list doesn't match"
    }

    println(s"standardListPattern = $standardListPattern")

    val standardListMatch = standardList match {
      case listOfStrings : List[String] => "a list of strings"
      case listOfIntegers : List[Int] => "a list of integers"
      case _ => "a list of some thing else"
    }

    println(s"standardListMatch = $standardListMatch")  // this returns list of strings
    // this is because of some internal things of JVM

    val sampleList = List(1,2,3,4,5)
    val head :: tail = sampleList
    println(s"head = $head, tail = $tail")

    val mappedList = sampleList.map { // we can have case classes with map function as well
      case x if x % 2 == 0 => "encountered an even number"
      case 1 => "the one"
      case _ => "something else"
    }

    println(s"mappedList = $mappedList")
  }
}
