public class Car {
   String initialValue = "Start";
  public static String staticinitialValue = "Start";

  public void ChangeValue(String str) {
    staticinitialValue = str;

  }

  public static void main(String[] args) {

    Car car = new Car();
    Car car2 = new Car();

    


    System.out.println("car.initialValue : " + car.initialValue);
    System.out.println("Car.staticinitialValue : "+ Car.staticinitialValue);

  }
}
