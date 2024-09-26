package ScalaObjectOrientedProgramming

object Concept1_OOPBasics {
  def main(args: Array[String]): Unit = {

    val p1 = Person("John", 26)
    println(p1)  // Output :- ScalaObjectOrientedProgramming.Person@45820e51
    // println(s"The age of the person p1 is :- ${p1.age}")
    // The above line throws an error because we can not access age column directly because it is a class parameter
    // Class parameters are not members of the class

    val np1 = new NewPerson("David", 40)
    println(s"The name of the person np1 is :- ${np1.name}")
    println(s"The age of the person np1 is :- ${np1.age}")
    println(s"The city of the person np1 is :- ${np1.city}")
    np1.greet("Daniel")  // calling the method present in the class

    val np2 = new NewPerson("Ramu", 45)
    np2.greet("Rohit")
    np2.greet()

    val np3 = new NewPerson("John Doe")  // accepted because of auxiliary constructor
    println(s"The age of the person np3 is :- ${np3.age}")
  }

}

class Person(name : String, age : Int)

// If we make the class parameters as either vals or vars then they become the members of the class
// It is not necessarily required to convert every class parameter into a field

class NewPerson(val name : String, val age : Int = 1) {

  val city = "Bangalore" // this is a field
  println("This the NewPerson class")

  def greet(name : String) : Unit = println(s"${this.name} says : Hi $name")
  // this keyword always refer to the current object
  // since the class field and the method are having the same name we have to explicitly use this keyword

  def greet() : Unit = println(s"Hi, I am $name") // In this line "this" is implicitly invoked
  // Here we have defined two functions with same name but different signatures
  // These type of methods are called overloaded methods

  // defining an auxiliary constructor
  def this(name : String) = this(name, 0)
  // Instead of creating auxiliary constructors like this we can use default arguments available for class
}
