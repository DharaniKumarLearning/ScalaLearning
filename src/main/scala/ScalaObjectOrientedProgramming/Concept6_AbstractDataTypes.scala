package ScalaObjectOrientedProgramming

object Concept6_AbstractDataTypes {
  def main(args: Array[String]): Unit = {

    abstract class Animal {
      val creatureType: String
      def eat(): Unit
    }

    // abstract classes are classes which doesn't have complete implementation of fields and methods
    // abstract classes can have non-abstract fields and methods as well
    // abstract classes can not be instantiated
    // val ab = new Animal --  Animal is abstract; it cannot be instantiated

    class Dog extends Animal {
      val creatureType: String = "German Shepherd"
      def eat(): Unit = println("Bow Bow")
    }

    val dog = new Dog
    println(s"d.creatureType = ${dog.creatureType}")
    println(s"Calling the eat() method in the dog class")
    dog.eat()

    // traits also can have abstract type and non-abstract types

    trait Carnivore {
      def eat(animal : Animal) : Unit
      val preferredMeal : String = "fresh meat"
      def isMealReady() : Unit = println("No not yet")
    }

    trait ColdBlooded {
      val preferredMeal : String = "Fresh blood"
      def eat(animal: Animal) : Unit
      def isMealReady() : Unit = println("Yes it is ready")
    }

    // a class can extend only one class whereas it can inherit multiple traits
    class Crocodile extends Animal with Carnivore with ColdBlooded {
      val creatureType : String = "Croc"
      def eat() : Unit = println("check check")
      def eat(animal: Animal) : Unit = println(s"${this.creatureType} eating ${animal.creatureType}")

      override val preferredMeal: String = "Good food"
      override def isMealReady() : Unit = {
        super[Carnivore].isMealReady()  // calling the Carnivore -- isMealReady function
        super[ColdBlooded].isMealReady()
        println("I have my meal ready")
      }
    }

    val crocodile = new Crocodile
    crocodile.eat()
    crocodile.eat(dog)
    println(crocodile.preferredMeal)
    crocodile.isMealReady()
    // traits are behavior whereas abstract classes are a type of thing
  }
}
