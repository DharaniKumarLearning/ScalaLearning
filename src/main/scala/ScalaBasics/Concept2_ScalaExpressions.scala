package ScalaBasics

object Concept2_ScalaExpressions {
  def main(args: Array[String]): Unit = {

    val aConditionedValue = if(10 > 20) 100 else 200  // if expression results in a value
    println(s"The data present in the value aConditionedValue is :- $aConditionedValue")

    var i = 0
    while (i < 10) {  // this is not good programming in Scala language
      println(s"The value of i is :- $i")
      i += 1
    }

    val aWeirdValue : Unit = {val aVariable = 3}  // this block of code will return Unit
    // Unit is same as void in other programming languages
    println(s"The data in the value aWeirdValue is :- $aWeirdValue ") // Unit type has the value ()

    // Side effects in Scala are println(), Unit(), while, reassignment

    val aCodeBlock = { // this is called code block
      val y = 100
      val z = y + 34  // the scope of the value z is within the code block
      if (z > 230) "Hello" else "Good Bye"
    }

    // code block is an expression
    // The value of the block is the value of the last expression
    print(s"The data in the value aCodeBlock is : $aCodeBlock")

    // val anotherValue = z + 2 -- this is incorrect since z is not in the scope
  }
}
