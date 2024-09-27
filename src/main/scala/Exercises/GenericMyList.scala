//package Exercises
//
//abstract class GenericMyList[+A] {
//  def head : A
//  def tail : GenericMyList[A]
//  def isEmpty : Boolean
//  def add[B >: A](element : B) : GenericMyList[B]
//  def printElements : String
//  override def toString : String = s"[$printElements]"
//
//  def map[B](transformer: MyTransformer[A, B]) : GenericMyList[B]
//  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]) : GenericMyList[B]
//  def filter(predicate : MyPredicate[A]) : GenericMyList[A]
//}
//
//object GenericEmptyList extends GenericMyList[Nothing] {
//  def head : Nothing = throw new NoSuchElementException
//  def tail : Nothing = throw new NoSuchElementException
//  def isEmpty : Boolean = true
//  def add[B >: Nothing](element : B) : GenericMyList[B] =
//    new GenericNonEmptyList(element, GenericEmptyList)
//  def printElements : String  = ""
//
//  def map[B](transformer: MyTransformer[Nothing, B]): GenericMyList[B] = GenericEmptyList
//  def flatMap[B](transformer: MyTransformer[Nothing, GenericMyList[B]]): GenericMyList[B] = GenericEmptyList
//  def filter(predicate: MyPredicate[Nothing]): GenericMyList[Nothing] = GenericEmptyList
//}
//
//class GenericNonEmptyList[+A](h : A, t : GenericMyList[A]) extends GenericMyList[A] {
//  def head : A = h
//  def tail : GenericMyList[A] = t
//  def isEmpty : Boolean = false
//  def add[B >: A](element : B) : GenericMyList[B] = new GenericNonEmptyList(element, this)
//  def printElements : String = {
//    if (t.isEmpty) "" + h
//    else s"$h ${t.printElements}"
//  }
//
//  def filter(predicate: MyPredicate[A]): GenericMyList[A] =
//    if
//
//}
//
//trait MyPredicate[-T] {
//  def test(element : T) : Boolean
//}
//
//trait MyTransformer[-A, B] {
//  def transform(elem : A) : B
//}
//
//object GenericListTest {
//  def main(args: Array[String]): Unit = {
//    val listOfIntegers : GenericMyList[Int] = GenericEmptyList
//    val listOfStrings : GenericMyList[String] = GenericEmptyList
//    println(listOfIntegers.add(10).add(20).toString)
//    println(listOfStrings.add("Hello").add("Scala").toString)
//
//    val intList = new GenericNonEmptyList(1, new GenericNonEmptyList(2, new GenericNonEmptyList(3, GenericEmptyList)))
//    println(intList)
//  }
//}