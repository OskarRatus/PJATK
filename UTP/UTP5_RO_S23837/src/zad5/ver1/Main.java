/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad5.ver1;


public class Main {
  public static void main(String[] args) {
    Author autor = new Author(args);
    new Thread(autor).start();
    new Thread(new Writer(autor)).start();
  }
}
