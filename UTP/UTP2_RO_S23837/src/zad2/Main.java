/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/*<--
 *  niezbędne importy
 */
public class Main {
  public static void main(String[] args) {

    Function<String, List<String>> flines = x -> {
      List<String> lineList = new ArrayList<>();

      try {
        Stream<String> stringStream = Files.lines(Paths.get(x));
        stringStream.forEach(lineList::add);
      } catch (IOException e) {
        e.printStackTrace();
      }

      return lineList;
    };

    Function<List<String>, String> join = x -> String.join("", x);

    Function<String, List<Integer>> collectInts = x -> {
      String[] str =  x.replaceAll("\\D"," ").split(" ");
      List<Integer> listInt = new ArrayList<>();
      for (String s :
              str) {
        if (s.length() > 0)
          listInt.add(Integer.parseInt(s));
      }
      return listInt;
    };

    Function<List<Integer>, Integer> sum = x -> x.stream().mapToInt(i -> i).sum();

    /*<--
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */

    String fname = System.getProperty("user.home") + "/LamComFile.txt";
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
