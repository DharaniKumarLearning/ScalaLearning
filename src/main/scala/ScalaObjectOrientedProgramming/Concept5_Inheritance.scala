package ScalaObjectOrientedProgramming

object Concept5_Inheritance {
  def main(args: Array[String]): Unit = {

    sealed class Animal {
      val creatureType = "wild"
      def eat() : Unit = println("Animal is eating")
      private def privateEat() : Unit = println("Not accessible outside class")
      protected def protectedEat() : Unit = println("Calling the protected eat method")
      final val canNotOverride = "try"
    }

    class Cat extends Animal  { // this is inheritance
      // override val canNotOverride = "check" -- we can not override a field or method that is defined final
      def crunch() : Unit = {
        protectedEat()  // protected method can be accessed inside the sub class
        println("Crunch")
      }
    }

    // Cat is sub-class of Animal
    // Animal is super class of Cat
    // Scala offers single class inheritance that means we can extend only one class at a time
    // Subclass only inherits non-private members of the parent class

    val cat = new Cat
    cat.eat()  // cat object can be used to call the Animal class methods
    // cat.privateEat() -- this statement returns error since private members can't be accessed
    cat.crunch()
    println(s"The data in the value creatureType for cat class is :- ${cat.creatureType}")

    // constructors
    class Person(name : String, age : Int) {
      def this(name : String) = this(name, 0)
    }
    // class Adult(name : String, age : Int, idCard : String) extends Person -- this is incorrect as we need to pass parameters to the Person class
    class Adult1(name : String, age : Int, idCard : String) extends Person(name, age)
    class Adult2(name : String, age : Int, idCard : String) extends Person(name) // this is valid because of auxiliary constructor

    // overriding
    class Dog extends Animal {
      override val creatureType: String = "domestic"
      override def protectedEat(): Unit = {
        super.protectedEat()  //calling the protectedEat method in parent class
        // super is used to call the parent class method
        println(s"overriding protected method in dog class")
      }
    }

    val d = new Dog
    d.protectedEat()
    println(s"The data in the creatureType in dog class is : ${d.creatureType}")

    class Dog2(override val creatureType : String) extends Animal  // we can override the value directly in constructor as well

    val d1 = Dog2("mild aggressive")
    println(s"The data in the creatureType variable in the Dog2 class is : ${d1.creatureType} ")

    // type substitution
    val unknownType : Animal = new Dog2("very very aggressive") // in a broad sense this is called polymorphism
    println(s"The data in the value unknownType is :- ${unknownType.creatureType}")
    // We can assign a child class type to parent class type

    // If we create a class with final then we can not use extends on that class
    // If we create a class with sealed then we can extend the class in the same file but we can not extend the class in other files
  }
}
