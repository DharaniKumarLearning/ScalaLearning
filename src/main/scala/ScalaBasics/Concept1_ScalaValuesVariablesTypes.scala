package ScalaBasics

object Concept1_ScalaValuesVariablesTypes {
  def main(args: Array[String]): Unit = {

    println("I am ready to learn Scala!")

    //Declaring Values

    val x : Int = 42
    println(s"The data in the value x is :- $x")
    // x = 100 -- we get reassignment to val error
    // Vals are immutable we can not change them once we create them just like final in java

    val y = 100  // The data types for vals are optional that's because the compiler can infer it
    println(s"The data in the value y is :- $y")

    // val z : Int = "Hello, Scala" -- compiler wanted Int but we gave String hence we get error

    val aString : String = "Hello";  // semi-colons are optional
    println(s"The data in the value aString is :- $aString")

    val aBoolean : Boolean = true
    val aChar : Char = 'a'
    val aShort : Short = 4000
    val aLong : Long = 582654942652L  // to define a long literal just add L at the end
    val aDouble : Double = 20.5
    val aFloat : Float = 2.0f

    println(s"""The data in the values we defined are :-
            |aBoolean = $aBoolean
            |aChar = $aChar
            |aShort = $aShort
            |aLong = $aLong
            |aDouble = $aDouble
            |aFloat = $aFloat""".stripMargin)

    // Declaring variables

    var aVariable : Int = 100
    println(s"The data in the variable aVariable before modifying :- $aVariable")
    aVariable = 200  //variables can be reassigned at later point of time
    println(s"The data in the variable aVariable after modifying :- $aVariable")
  }
}
