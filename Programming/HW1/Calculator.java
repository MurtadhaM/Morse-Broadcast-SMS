public class Calculator{  
    void sum(int a,long b){
  System.out.println("Inside sum(int,long) method");
  System.out.println(a+b);
  }   
    void sum(float a,long b){
  System.out.println("Inside sum(float,long) method");
  System.out.println(a+b);
  }
    public static void main(String args[]){  
    Calculator obj=new Calculator ();  
                  obj.sum(20,20);
                  obj.sum(20.5f,20);
    }  
  }   
  