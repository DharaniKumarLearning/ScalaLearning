package Exercises

abstract class MyList {
  def head : Int
  def tail : MyList
  def isEmpty : Boolean
  def add(element : Int) : MyList
  def printElements : String
  override def toString : String = s"[$printElements]"
}

object EmptyList extends MyList {
  def head : Int = throw new NoSuchElementException
  def tail : MyList = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add(element : Int) : MyList = new NonEmptyList(element, EmptyList)
  def printElements : String = ""
}

class NonEmptyList(h : Int, t : MyList) extends MyList {
  def head : Int = h
  def tail : MyList = t
  def isEmpty : Boolean = false
  def add(element : Int) : MyList = new NonEmptyList(element, this)
  def printElements : String =
    if(t.isEmpty) "" + h
    else s"$h,${t.printElements}"
}

object ListTest {
  def main(args: Array[String]): Unit = {
    val emptyList = EmptyList
    val oneElementList = emptyList.add(10).add(20).add(30)
    println(oneElementList)
  }
}