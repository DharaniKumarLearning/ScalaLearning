package ScalaBasics

object Concept7_StringOperations {
  def main(args: Array[String]): Unit = {

    val sampleString : String = "Hello I am learning scala"  // String index starts with 0
    println(s"The original string is :- $sampleString")
    println(s"The character at index 1 in the string is :- ${sampleString.charAt(1)}")
    println(s"The characters in the string starting from index 15 is :- ${sampleString.substring(15)}")
    println(s"The characters between the index 8 and 11 is :- ${sampleString.substring(8, 12)}") // begin to end - 1
    println(s"Splitting the string into individual words :- ${sampleString.split(" ").toList}")
    println(s"Does the string starts with Hello :- ${sampleString.startsWith("Hello")}")
    println(s"Does the string ends with scala :- ${sampleString.startsWith("scala")}")
    println(s"Replacing all the spaces in the string with comma :- ${sampleString.replace(" ", "-")}")
    println(s"Converting the string to lowercase :- ${sampleString.toLowerCase()}")
    println(s"Converting the string to uppercase :- ${sampleString.toUpperCase()}")
    println(s"The number of characters present in the string is :- ${sampleString.length}")

    val aNumberString = "45"
    val aNumber : Int = aNumberString.toInt
    println(s"The data in the value aNumber is :- $aNumber")
    println(s"The reverse of the string is :- ${sampleString.reverse}")
    println(s"Extracting the first 4 characters in the string :- ${sampleString.take(5)}")
    println(s"Extracting the last 5 characters in the string :- ${sampleString.takeRight(5)}")

    // There are 3 string interpolators in scala
    // s interpolator, f interpolator and raw interpolator
    val name = "David"
    val aTime = 1.2f
    println(s"$name can eat $aTime burgers per minute")
    println(f"$name can eat $aTime%.2f burgers per minute")  // printf style formatting
    println(raw"This is a newline \n character but raw interpolator won't print it")
    val escapeString = "This is a newline \ncharacter"
    println(raw"The data of the value escapeString is :- $escapeString ")
    // When we incorporate the \n in a variable raw interpolator prints it
  }
}
