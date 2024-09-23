package ScalaBasics

object Concept5_CallByValueCallByName {
  def main(args: Array[String]): Unit = {

    def calledByValue(x : Long) : Unit = {
      println(s"by value x is :- $x")
      println(s"by value x is :- $x")
    }

    def calledByName(x: => Long): Unit = { // call by name
      println(s"by name x is :- $x")
      println(s"by name x is :- $x")
    }

    calledByValue(System.nanoTime())  // In call by value the System.nanoTime() is computed only once
    calledByName(System.nanoTime())
    // In call by name the System.nanoTime() is evaluated every time we use the variable in the function

    /*
      by value x is :- 27935771615875
      by value x is :- 27935771615875
      by name x is :- 27935828699208
      by name x is :- 27935829030250
    */

    def infinite() : Int = 1 + infinite()
    def printFirst(x : Int, y : => Int) : Unit = println(x)

    printFirst(10, infinite())
    // in this call infinite function doesn't gets called bcoz we didn't use it inside the function

    // printFirst(infinite(), 10) -- this will throw stackoverflow error
  }
}
