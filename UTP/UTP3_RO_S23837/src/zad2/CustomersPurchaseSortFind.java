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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomersPurchaseSortFind {

    List<Purchase> allCustomers = new ArrayList<>();

    public CustomersPurchaseSortFind() {
    }


    public void readFile(String fname) {
        try {
            Stream<String> stringStream = Files.lines(Paths.get(fname));
            stringStream.forEach(line -> {
                Purchase purchase = new Purchase(line);
                allCustomers.add(purchase);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showSortedBy(String filterBy) {
        System.out.println(filterBy);

        if (filterBy == "Nazwiska")
            allCustomers.stream().sorted((o1, o2) -> {
                if (o1.getNazwisko().compareTo(o2.getNazwisko()) == 0)
                    return o1.getId_klienta().compareTo(o2.getId_klienta());
                return o1.getNazwisko().compareTo(o2.getNazwisko());
            })
                            .forEach(c -> System.out.println(c.getLinia()));
        else if (filterBy == "Koszty"){
            allCustomers.stream().sorted((o1, o2) -> {
                if (o1.getKoszt() == o2.getKoszt())
                    return o1.getId_klienta().compareTo(o2.getId_klienta());
                return Double.compare(o2.getKoszt(),o1.getKoszt());
            })
                    .forEach(c -> System.out.println(c.getLinia() + " (koszt: " + c.getKoszt() + ")"));
        }
        System.out.println();

    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        allCustomers.stream()
                .filter(purchase -> purchase.getId_klienta().equalsIgnoreCase(id))
                .forEach(purchase -> System.out.println(purchase.getLinia()));
        System.out.println();    }
}
