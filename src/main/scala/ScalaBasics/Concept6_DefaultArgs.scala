package ScalaBasics

import scala.annotation.tailrec

object Concept6_DefaultArgs {
  def main(args: Array[String]): Unit = {

    @tailrec
    def goodFactorial(n : Int, accumulator : Int = 1) : Int = {  // passing the default arguments
        if (n == 1) accumulator
        else goodFactorial(n - 1, n * accumulator)
    }

    println(s"The factorial of the number 10 is :- ${goodFactorial(10)}")

    def savePicture(format : String = "jpg", width : Int = 1920, height : Int = 1080) : Unit =
      println(s"Saving the picture with $format with width = $width and height = $height")

    savePicture()
    savePicture("bmp")
    // savePicture(800)  // this will throw error bcoz the compiler is confused to which parameter it needs to assign 800
    savePicture(width = 800)  // you can use named arguments
    savePicture(height = 600, width = 900, format = "bmp")  // when we use named arguments order doesn't matter
  }
}
