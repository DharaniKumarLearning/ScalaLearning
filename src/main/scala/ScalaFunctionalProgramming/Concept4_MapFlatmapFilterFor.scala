package ScalaFunctionalProgramming

object Concept4_MapFlatmapFilterFor {
  def main(args: Array[String]): Unit = {

    val sampleList = List(1,2,3,4,5,6)
    println(s"The sampleList = $sampleList")
    println(s"The first element in the list is :- ${sampleList.head}")
    println(s"The sampleList without the first element is :- ${sampleList.tail}")
    println(s"Applying the map function on sampleList :- ${sampleList.map(_ + 1)}")
    println(s"Applying the map function on sampleList :- ${sampleList.map(_ + " is a number")}")
    println(s"Applying filter function on sampleList :- ${sampleList.filter(_ % 2 == 0)}")

    val toPair : Int => List[Int] = x => List(x, x + 1)
    println(s"Applying the map function on sampleList by passing toPair function " +
      s":- ${sampleList.map((x : Int) => toPair(x))}")
    println(s"Applying the flatMap function on sampleList by passing toPair function " +
      s":- ${sampleList.flatMap((x: Int) => toPair(x))}")

    val numbers = List(1,2,3,4)
    val characters = List('a', 'b', 'c', 'd')
    val colors = List("Black", "White")

    // Instead of writing loops we can use flatMap and map in functional programming language
    println(s"${characters.flatMap{
      x => {
        numbers.flatMap{
          y => colors.map(color => x.toString + y + "-" + color)
        }
      }
    }}")

    sampleList.foreach(println)

    // doing the same thing using loops
    val forCombinations = for {
      x <- characters
      y <- numbers if y % 2 == 0  // we can filter some values if we want
      color <- colors
    } yield x.toString + y + "-" + color

    println(s"combinations using for loop is :- ${forCombinations}")
  }
}
