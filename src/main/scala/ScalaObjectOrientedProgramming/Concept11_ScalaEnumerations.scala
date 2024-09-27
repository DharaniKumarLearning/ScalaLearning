package ScalaObjectOrientedProgramming

object Concept11_ScalaEnumerations {
  def main(args: Array[String]): Unit = {

    // An enumeration is used to define a type consisting of a set of named values
    // enum is a data type we can define much like a class
    enum Permissions { // Permissions is a enum that will have bunch of instances
      case READ, WRITE, EXECUTE, NONE

      // we can add fields and methods to enum
      def openDocument() : Unit =
        if (this == READ) println("opening document..")
        else println("sorry you don't have permission to read the document")
    }

    enum PermissionsWithBits(val bits : Int) {
      case READ extends PermissionsWithBits(4)
      case WRITE extends PermissionsWithBits(2)
      case EXECUTE extends PermissionsWithBits(1)
      case NONE extends PermissionsWithBits(0)
    }

    object PermissionsWithBits {
      def fromBits(bits : Int) : PermissionsWithBits =
        PermissionsWithBits.NONE
    }

    val readPermissions : Permissions = Permissions.READ
    val readPermissionsOrdinal = readPermissions.ordinal  // ordinal returns the position at which we defined the value
    val executePermissions : Permissions = Permissions.EXECUTE
    println(readPermissions)
    println(s"The ordinal of readPermissions is :- ${readPermissionsOrdinal}")
    println(executePermissions)
    executePermissions.openDocument()
    readPermissions.openDocument()


    val newPermissions = PermissionsWithBits.READ
    println(newPermissions)
    println(newPermissions.bits)
    val allPermissions = PermissionsWithBits.values  // written all the values in enum
    println(allPermissions.mkString(","))

    val executePermission : PermissionsWithBits = PermissionsWithBits.valueOf("EXECUTE")
    println(executePermission)
  }
}
