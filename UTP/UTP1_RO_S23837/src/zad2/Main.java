/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad2;


import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(sel -> {
                         String s = sel;
                         return s.startsWith("WAW");
                               }
                        )
                       .mapEvery(map -> {
                         String[] strings = map.split(" ");
                         return "to " + strings[1] + " - price in PLN:\t" + (int)(Integer.parseInt(strings[2])*xrate);
                               }
                        );
  }



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
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
