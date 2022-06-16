import java.util.Scanner;

public class classes {
    public static void main(String[] args) {

      System.out.println("Enter  a Goddamned number: ");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();


      System.out.println("THIS IS YOU GODDAMN INPUT:" + n);

      System.out.println("Shuv " + n + " into your ass");
    }

  }



class Animal {

  public String name;
  public String Species;
  public Animal(String name, String Species) {
    this.name = name;
    this.Species = Species;
  }

  public void Move() {
    // Handeling the movement of the animal
    if (Species.equals("Snake")) {
      System.out.println("Snake in slithering");
    } else if (Species.equals("Cat")) {
      System.out.println("Cat is moving");
    } else {
      System.out.println("Animal is moving");
    }
  }

}
