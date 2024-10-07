package ScalaFunctionalProgramming

import scala.util.Random

object Concept5_ScalaCollections {
  def main(args: Array[String]): Unit = {
    /*
       Scala offers both mutable and immutable collections
          mutable collections can be changed in place
          immutable collections can never change
       We will be using the immutable collections by default
       Traversable is the base trait for all the collections. Offers a great variety of methods
          maps :- map, flatMap, collect
          conversions :- toArray, toList, toSeq
          size info :- isEmpty, size, nonEmpty
          tests :- exists, forall
          folds :- foldLeft, foldRight, reduceLeft, reduceRight
          retrieval :- head, find, tail
          StringOps :- mkString
    */

    // Sequences

    /*
      A general interface for data structures that
        have a well defined order
        can be indexed

      Supports various operations:
        apply, iterator, length, reverse for indexing and iterating
        concatenation, appending, prepending,
        a lot of others : grouping, sorting, zipping, searching, slicing
    */

    val aSequence = Seq(1, 2, 3, 4) // immutable collection
    println(aSequence) // this will actually print list because Sequence companion object creates list
    println(aSequence.reverse)
    println(aSequence(2)) // accessing the index present at index 2
    println(aSequence ++ Seq(5, 6, 7)) // concatenation
    println(Seq(7, 5, 6, 2).sorted)

    val aRange: Seq[Int] = 1 to 10 // here we are creating a range collection
    aRange.foreach(println)

    (1 to 10).foreach(x => println("Hello"))

    // Lists
    /*
      A LinearSeq immutable linked list
        head, tail, isEmpty methods are fast : O(1)
        most operations are O(n) :- length, reverse
    */

    val aList = List(1, 2, 3)
    println(s"Prepending an element to aList :- ${42 :: aList}")
    println(s"Prepending and appending an element to aList :- ${67 +: aList :+ 98}")
    println(aList) // list is not changed because it is immutable

    val apple5 = List.fill(5)("apple") // creating a list with 5 times the value "apple" in it
    println(apple5)
    println(apple5.mkString("-"))

    // Arrays
    /*
      The equivalent of simple Java arrays
        -- can be manually constructed with predefined lengths
        -- can be mutated (updated in place)
        -- are interoperable with Java's T[]arrays
        -- indexing is fast we can access any element at constant time
    */

    val numbers = Array(1, 2, 3)
    val threeElements = Array.ofDim[Int](3) //creating a Array with 3 elements by default it will have value zero in it
    println(numbers.mkString(","))
    println(threeElements.mkString(",")) // 0, 0, 0
    numbers(2) = 100 // mutating the array internally called as numbers.update(2, 100)
    println(numbers.mkString(","))

    val numbersSeq: Seq[Int] = numbers // here it does a implicit conversion to ArraySeq
    println(numbersSeq) // ArraySeq(1, 2, 100)

    // Vectors
    /*
      effectively constant indexed read and write: O(log(n))
      fast element addition : append/ prepend
      good performance for large sizes
    */

    val aVector: Vector[Int] = Vector(1, 2, 3)
    println(aVector)

    // Vectors vs Lists

    val maxRuns = 1000
    val maxIterations = 10000

    def getWriteTime(collection: Seq[Int]): Double = {

      val r = new Random
      val times = for {
        it <- 1 to maxRuns
      } yield {
        val currentTime = System.nanoTime()
        collection.updated(r.nextInt(maxIterations), r.nextInt())
        System.nanoTime() - currentTime
      }

      times.sum * 1.0 / 2
    }

    // lists keep reference to tail
    // updating an element in the middle takes long
    val numbersList = (1 to maxIterations).toList

    // depth of the tree is small
    // needs to replace an entire 32-element chunk
    val numbersVector = (1 to maxIterations).toVector

    println(getWriteTime(numbersList))
    println(getWriteTime(numbersVector))

    // Tuples -- different ways of creating tuples
    val aTuple = new Tuple2[Int, String](2, "Hello Scala")
    val aTuple1 = Tuple2[Int, String](2, "Hello Scala")
    val aTuple2 = (2, "Hello Scala")

    println(s"aTuple = $aTuple, aTuple1 = $aTuple1, aTuple2 = $aTuple2")
    println(s"The first element in the aTuple2 is :- ${aTuple2._1} ")
    val tupleCopy = aTuple2.copy(_2 = "goodbye java") // we can use copy method on tuples
    println(s"tupleCopy = $tupleCopy")
    println(s"Swapping the tuple :- ${aTuple2.swap}")

    // Maps
    val aMap : Map[String, Int] = Map()
    val phoneBook = Map(("Jim",5555),("Daniel", 789), "John" -> 900).withDefaultValue(-1)
    println(s"phoneBook = $phoneBook")
    println(phoneBook.contains("John"))
    println(phoneBook("Daniel"))
    println(phoneBook("Ram"))  // if the specified key doesn't exist in the map we can get the default value

    val aPair = "Mary" -> 890
    val newPhoneBook = phoneBook + aPair  // creating a new map because by default map is immutable
    println(s"newPhoneBook = $newPhoneBook")
    println(newPhoneBook.maxBy(pair => pair._2))  //returns the key/value pair that has the maximum value
    println(newPhoneBook.maxBy(pair => pair._2)._1) // this syntax will return us only the key
    println(newPhoneBook.count(pair => pair._2 >= 900))

    // functionals on maps
    println(newPhoneBook.map(pair => pair._1.toLowerCase -> pair._2 * 2))
    println(newPhoneBook.filter(x => x._1.startsWith("J")))
    println(newPhoneBook.toList)  //converting map to list
    println(List(("D",98),("F",90)).toMap) //converting list of tuples to map

    val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
    println(names.groupBy(name => name.charAt(0)))  //group by the first character

    println(Set("Ram","Ram","H").tail)
  }
}
