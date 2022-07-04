/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    HashMap<String, List<String>> dict = new HashMap<>();

    try {
      URL url = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

      Stream<String> lines = bufferedReader.lines();
      lines.forEach(o -> {
        char[] chars = o.toCharArray();
        Arrays.sort(chars);
        String charsSorted = String.valueOf(chars);

        if (!dict.containsKey(charsSorted))
          dict.put(charsSorted, new ArrayList<>());

        dict.get(charsSorted).add(o);
      });

      int maxSize = dict.entrySet().stream()
              .max((o1, o2) -> o1.getValue().size() > o2.getValue().size() ? 1 : -1)
              .get()
              .getValue()
              .size();

      dict.entrySet().stream()
              .filter(o -> o.getValue().size() == maxSize)
              .forEach(o -> System.out.println(String.join(" ", o.getValue())));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
