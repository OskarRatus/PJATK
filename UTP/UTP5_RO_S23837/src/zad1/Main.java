/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad1;


public class Main {

  public static void main(String[] args) throws InterruptedException {
    Letters letters = new Letters("ABCD");
    for (Thread t : letters.getThreads()) System.out.println(t.getName());
    for (Thread t : letters.getThreads()) t.start();


    Thread.sleep(5000);

    for (Thread t : letters.getThreads()) {
      if (t.isAlive())
        t.interrupt();
    }

    System.out.println("\nProgram skończył działanie");
  }

}
