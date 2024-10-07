package ScalaFunctionalProgramming

object Concept6_ScalaOption {
  def main(args: Array[String]): Unit = {

    // An option is a wrapper for a value that might be present or not
    // Options are a functional way of delaying with absence of a value
    val myFirstOption : Option[Int] = Some(4)
    val noOption : Option[Int] = None

    println(s"myFirstOption = $myFirstOption")
    println(s"noOption = $noOption")

    def unSafeMethod() : String = null
//    val result = Some(unSafeMethod()) // It is WRONG to do like this
    val result = Option(unSafeMethod()) // It will take Some or None
    println(s"result = $result")

    def backUpMethod() : String = "A valid result"
    val chainedResult = Option(unSafeMethod()).orElse(Option(backUpMethod()))
    println(s"chainedResult = $chainedResult")

    def betterUnsafeMethod() : Option[String] = None
    def betterBackupMethod() : Option[String] = Some("A valid result")
    val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())
    println(s"betterChainedResult = $betterChainedResult")

    // functions on options
    println(myFirstOption.isEmpty)
    println(myFirstOption.get)  // do not use this if the option has None value we will get java.util.NoSuchElementException
    println(noOption.getOrElse("Empty value"))

    println(myFirstOption.map(_ * 2))
    println(myFirstOption.filter(_ % 2 == 1))
    println(myFirstOption.flatMap(x => Option(x * 10)))

    // Options will help us eliminate lot of null checks in our code
    // If you think your code might return null use options
  }
}
