class Counter {
  int count = 0;
  public void increment() {
    count++;
  }
  public int getCount() {
    return count;
  }
}
public class Threads {




  public static void main(String[] args) {

    Counter c = new Counter();
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 100ww000; i++) {
          c.increment();
        }
      }
    });
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 100000; i++) {
          c.increment();
        }
      }
    });

    t1.run();
    t2.run();


    System.out.println(c.getCount());
  }


}
