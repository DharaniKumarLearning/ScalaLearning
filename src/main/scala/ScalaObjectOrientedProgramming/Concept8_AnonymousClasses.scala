package ScalaObjectOrientedProgramming

object Concept8_AnonymousClasses {
  def main(args: Array[String]): Unit = {

    abstract class Animal {
      def eat : Unit
    }

    // Anonymous class
    val funnyAnimal : Animal = new Animal {
      override def eat: Unit = println("hahahahahah")
    }

    /*
      What exactly did compiler do here is? created an anonymous class
        class Concept8_AnonymousClasses$$anon$1 extends Animal {
            override def eat: Unit = println("hahahahahah")
        }
    */

    println(funnyAnimal.getClass) // class ScalaObjectOrientedProgramming.Concept8_AnonymousClasses$$anon$1

    class Person(name : String) {
      def sayHi() : Unit = println(s"Hi, My name is $name. How can I help?")
    }

    val jim = new Person("Jim") {
      override def sayHi() : Unit = println(s"Hi, My name is Jim. How can I help?")
    }

    jim.sayHi()
    // Anonymous classes works on traits and classes(abstract or not)
  }
}
