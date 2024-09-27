package ScalaObjectOrientedProgramming

object Concept4_ScalaObjects {

  def main(args: Array[String]): Unit = {

    // Scala doesn't have class-level functionality like static methods or variables in Java
    // Instead Scala has objects

    object Person { // To use class level definition in Scala we use objects
      val N_EYES = 2

      def canFly: Boolean = false

      // this is called factory method
      def apply(father : Person, mother : Person) : Person = new Person("Bobby")
    }

    class Person(val name : String) {
      // instance level functionality is placed inside the class definition
    }

    // When the class and object have the same name then are called Companions
    // Scala companions can access each other's private members

    println(s"The data in the value N_EYES = ${Person.N_EYES}")
    println(s"Can a Person fly? ${Person.canFly}")

    // Scala object is a singleton instance
    // Once we define an object :- it will define a type + the only instance for it

    val mary = new Person("Mary")
    val john = new Person("John")
    println(s"Is p1 and p2 same :- ${mary == john}")

    val p3 = Person
    val p4 = Person
    println(s"Is p3 and p4 same :- ${p3 == p4}")
    // The above statement returns true because when we say Singleton
    //  there is a single instance that we can refer to Person

    val bobby = Person(mary, john)  // apply method is called here
    println(s"The object created using apply method is :- ${bobby.name}")

    // Scala applications are methods with name main with the below exact definition
    // def main(args : Array[String]) : Unit = {
  }

}
