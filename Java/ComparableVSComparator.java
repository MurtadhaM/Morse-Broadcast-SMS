import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparable<Person> {
  @Override
  public int compareTo(Person p) {
    if (this.age > p.age) {
      return 1;
    } else if (this.age < p.age) {
      return -1;
    } else {
      return 0;
    }

  }
  String name;
  int age;
  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

}
public class ComparableVSComparator {
  public static void main(String[] args)  {
    Person person1 = new Person("John", 20);
    Person person2 = new Person("Abu", 71);
    Person person3 = new Person("Israel", 22);
    Person person4 = new Person("Meagan", 55);

    ArrayList<Person> people = new ArrayList<>();
    people.add(person1);
    people.add(person2);
    people.add(person3);
    people.add(person4);

    Comparator<Person> sortbyAge   =   (p1, p2) ->   (p1.age == p2.age) ? 0 : (p1.age > p2.age) ? 1 : -1;
    


    Comparator<Person> sortbyName = (PersonA, PersonB) -> PersonA.name.compareTo(PersonB.name);
  
      

    Collections.sort(people, sortbyName);
    for (Person p : people) {
      System.out.println(" " + p.name + "||  " + p.age);

    } 
    




  }

}
