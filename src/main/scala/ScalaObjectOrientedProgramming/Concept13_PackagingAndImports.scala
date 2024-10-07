package ScalaObjectOrientedProgramming

import Exercises.{SampleClass, SampleClass1 as NewClass}

import java.sql
import java.util.Date
import java.sql.Date

object Concept13_PackagingAndImports {
  def main(args: Array[String]): Unit = {

    // We can access the other classes present in a different file in same package directly
    // Package members are accessible by simple name
    val writer = new Writer("John", "Jim", 1990)

    // If the class/method is not in the same package then you need to import it
    val sampleObject = new SampleClass  // without the import statement we can not create an object of SampleClass
    val sampleObject1 = new NewClass
    // packages are in hierarchy it matches the folder structure

    // default package imports -- java.lang (String, Exception), scala (Int, Float, Nothing, Predef)

  }
}
