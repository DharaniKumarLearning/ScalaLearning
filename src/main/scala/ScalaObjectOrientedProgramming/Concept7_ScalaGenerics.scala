package ScalaObjectOrientedProgramming

// Generics use the same code on potentially unrelated types

object Concept7_ScalaGenerics {
  def main(args: Array[String]): Unit = {

    class MyList[A]  { // passing a type parameter to the class MyList
      // use type A inside the class MyList
    }

    trait MyMap[Key, Value]  // we can have type parameter to traits as well

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]

    object MyList { //objects can not be type parameterized
      // defining a generic method
      def empty[A] : MyList[A] = new MyList[A]
    }

    val emptyListOfIntegers = MyList.empty[Int]
    val emptyListOfStrings = MyList.empty[String]

    // variance problem
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // If Cat extends Animal then List[Cat] also extends List[Animal]
    // 1. yes -- List[Cat] extends List[Animal] -- this behavior is called covariance
    class CoVariantList[+A]
    val animalList : CoVariantList[Animal] = new CoVariantList[Cat]  // Replacing List[Animal] with List[Cat]
    // animalList.add(new Dog) ??? Hard question -- yes we return list of Animals

    // 2. No -- Invariance
    class InvariantList[A]
    // val invariantAnimalList : InvariantList[Animal] = new InvariantList[Dog] -- this is incorrect
    // Invariant class
    val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]

    // 3. Hello No -- Contravariant classes
    class ContraVariantList[-A]
    val contraVariantList : ContraVariantList[Cat] = new ContraVariantList[Animal]
    // here we are replacing List[Cat] with List[Animal] even though Cat is sub type of Animal

    class Trainer[-A]
    val trainer : Trainer[Cat] = Trainer[Animal]
    // In this example semantics will change Trainer[Animal] can easily train Trainer[Cat]

    // bounded types -- use generic classes only for certain types
    class Cage[A <: Animal](animal : A)  // Cage class accepts types which are sub type of Animal

    val cage1 = new Cage(new Dog)  // since Dog is subtype of Animal this works fine
    val cage2 = new Cage(new Animal)

    class Test
    // val cage3 = new Cage(new Test) -- this is error because Test is not a subtype of Animal

    class NewCage[A >: Animal](animal : A) // here we are telling NewCage accepts type that are greater than the type Dog
    val newCage1 = new NewCage(new Dog)

    class NewMyList[+A] {
      // def add(element : A) : NewMyList[A] -- this throws an error
      def add[B >: A](element : B) : NewMyList[B] = ???
    }
  }
}
