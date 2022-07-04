/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad1;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;

    List<String> result = dest.stream()
            .filter(fil -> fil.startsWith("WAW"))
            .map(s -> {
              String[] str = s.split(" ");
              return "to " + str[1] + " - price in PLN:\t" + (int)(Integer.parseInt(str[2])*ratePLNvsEUR);
            })
            .collect(Collectors.toList());

    for (String r : result) System.out.println(r);
  }
}
