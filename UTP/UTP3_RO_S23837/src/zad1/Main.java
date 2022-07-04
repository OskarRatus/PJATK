/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad1;


import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    String home = System.getProperty("user.home");
    String allWords = home + "/allwords.txt";

    System.out.println(allWords);
    Anagrams an = new Anagrams(allWords);
    an.getSortedByAnQty();
    for(List<String> wlist : an.getSortedByAnQty()) {
      System.out.println(wlist);
    }
    System.out.println("************************");
    Scanner scan = new Scanner(new File(home, "wordsToFind.txt"));
    while(scan.hasNext()) {
      System.out.println(an.getAnagramsFor(scan.next()));
    }
    scan.close();
  }
}
