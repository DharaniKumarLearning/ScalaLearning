package ScalaObjectOrientedProgramming

import scala.language.postfixOps

object Concept3_MethodNotations {
  def main(args: Array[String]): Unit = {

    // We wrote the Person class inside main method because we already have a Person class
    // defined in the Concept1_OOPBasics object

    class Person(val name : String, favoriteMovie : String, val age : Int = 0) {

      def likes(movie : String) : Boolean = movie == favoriteMovie
      def learns(concept : String) : String = s"$name learns $concept"
      def learnsScala : String = learns("Scala")

      // We can have operators as method names
      def +(person : Person) : String = s"${this.name} is hanging out with ${person.name}"
      def +(anotherName : String) : Person = new Person(s"${this.name} ($anotherName)",this.favoriteMovie)

      def unary_! : String = s"$name?what the heck"
      def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

      def apply() : String = s"Hi My name is $name and I like $favoriteMovie and my age is $age"
      def apply(times : Int) : String = s"Hi My name is $name, I watched movie $favoriteMovie $times times"

    }

    val mary = new Person("Mary", "Inception")
    println(s"Calling the likes method using .(dot) notation :- ${mary.likes("Inception")}")
    println(s"Calling the likes method using operator notation :- ${mary likes "Inception"}")  // this is infix notation or operator notation
    // the above syntax works with methods that have only one parameter

    val tom = new Person("Tom", "Fight Club")
    println(s"Calling the + method in Person class using operator notation ${mary + tom}")
    println(s"Calling the overloaded + method in Person class using operator notation :- " +
      s"${(mary + "the rockstar")()}")  // here we are calling the apply method
    
    // Operators are actually methods in scala
    println(1 + 2)
    println(1.+(2))  // this line is equivalent to the above line
    // calling the method in operator notation is actually a syntactic sugar

    // prefix notation
    val x = -1  // here -(minus) is actually a method
    val y = 1.unary_-  // unary_- is the method that gets called
    println(s"The data in the value x = $x and the data in the value y is $y")

    println(!mary)
    println((+mary)())
    println(mary.unary_!)  //unary_ prefix only works for +, -, ~, !

    // apply method
    println(mary.apply())
    println(mary())  // both the lines are equivalent
    // Whenever the compiler sees an object being called as an method it looks for the definition of method named apply
    println(mary(10))  // We can have multiple apply methods as well in the class
    // The compiler will correctly call the required apply method

    // postfix notation
    println(s"Calling the learnsScala method using postfix notation :- ${mary learnsScala}")
  }
}


