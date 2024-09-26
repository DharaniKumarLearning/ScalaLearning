package ScalaObjectOrientedProgramming

object Concept2_OOPBasics2 {
  def main(args: Array[String]): Unit = {

    val author1 = new Writer("Ram", "Robert", 1990)
    val author2 = new Writer("Ram", "Robert", 1990)
    val novel1 = new Novel("Great Expectations", 2020, author1)
    println(s"The author age of the novel ${novel1.name} is ${novel1.authorAge()}")
    println(s"Is novel1 written by author1 :- ${novel1.isWrittenBy(author1)}")
    println(s"Is novel1 written by author2 :- ${novel1.isWrittenBy(author2)}")

    val c = new Counter()
    println(s"The value of the counter is :- ${c.inc.inc.dec.inc.returnCounter}")
    println(s"The value of the counter is :- ${c.inc(10).inc.dec.inc.returnCounter}")
  }
}

class Writer(val firstName : String, val surName : String, val birthYear : Int) {
  def fullName : String = s"$firstName $surName"
}

class Novel(val name : String, val yearOfRelease : Int, val author : Writer) {
  def authorAge() : Int = yearOfRelease -  author.birthYear

  def isWrittenBy(author : Writer) : Boolean = author.fullName == this.author.fullName
  // this keyword every time refers to the current object

  def copy(newYearRelease : Int) : Novel = new Novel(name, newYearRelease, author)
}

class Counter(val aInt : Int = 0) {

  def inc : Counter = new Counter(aInt + 1) // these are called parameter less methods
  def dec : Counter = new Counter(aInt - 1)

  def inc(n : Int) : Counter = new Counter(aInt + n)
  def dec(n : Int) : Counter = new Counter(aInt + n)

  def returnCounter : Int = aInt
}