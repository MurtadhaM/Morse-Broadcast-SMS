import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person : Comparable<Person> {
  override fun compareTo(other: Person): Int {
    return if (this.age > other.age) {
      1
    } else if (this.age < other.age) {
      -1
    } else {
      0
    }
  }
  var name: String
  var age: Int
  constructor(name: String, age: Int) {
    this.name = name
    this.age = age
  }
   
}

class ComparableVSComparator {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {

      val people = listOf<Person>(
        Person("Alice", 48),
        Person("Dave", 31),
        Person("Carol", 67),
        Person("Bob", 33),
        Person("Murtadha", 10)


    )
    var sortbyAge: Comparator<Person> =  Comparator { p1, p2 -> (p1.age.compareTo(p2.age))  }
    var sortbyName = Comparator<Person> { p1, p2 -> p1.name.compareTo(p2.name) }
   people.sortedWith(sortbyAge).forEach{value -> println(value.age) }
   people.sortedWith(sortbyName)
    people.forEach { value -> println(value.name)}


    } 
  }
}


    