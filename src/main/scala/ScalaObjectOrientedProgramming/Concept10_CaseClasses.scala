package ScalaObjectOrientedProgramming

object Concept10_CaseClasses {
  def main(args: Array[String]): Unit = {

    case class Person(name : String, age : Int)

    /*
        Use of case classes
        1. Class parameters are promoted to fields
        2. It creates a sensible toString
        3. equals and hashCode method are implemented
        4. provides a copy method
        5. case classes by default have a companion object that's why we will be able to create an object for
            case class without using new
        6. case classes are serializable which makes it easy to send case classes between JVM's easy
        7. case classes can be used in pattern matching
     */

    val jim = Person("Jim", 34)  // new is not mandatory while creating a case class object
    println(jim.name)
    println(jim.toString)
    println(jim)  // this will automatically call the toString method

    val jim2 = Person("Jim", 34)
    println(jim == jim2)  // this returns true because of equals method implementation
    // In normal classes the above statement returns false since both jim and jim2 point to different instances

    val jim3 = jim.copy()
    println(jim3)

    val jim4 = jim.copy(age = 45)  // we can pass a different value to a parameter if we want
    println(jim4)

  }
}
