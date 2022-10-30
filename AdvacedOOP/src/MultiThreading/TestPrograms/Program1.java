package MultiThreading.TestPrograms;

//Hello Threads
class ThreadX extends Thread {

  //this is a method overridden when extending Thread
  //same overriding as toString
  public void run() {
    try {
      while(true) {
        //sleep for 2 seconds
        Thread.sleep(2000);
        //output hello after 2 seconds
        System.out.println("Hello");
      }
    }
    catch(InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}

public class Program1{

  public static void main(String args[]) {
    
    ThreadX tx = new ThreadX();
    tx.start();
  }
}