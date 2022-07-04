package zad4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Producer extends Thread {
    private Towar towar;
    private int count = 0;

    public Producer(Towar towar) {
        this.towar = towar;
    }

    @Override
    public void run() {
        try {
            Files.readAllLines(Paths.get("..\\Towary.txt"))
                    .stream()
                    .forEach(str -> {
                        towar.setValues(str.split(" ")[0], Double.parseDouble(str.split(" ")[1]));
                        if ((++count % 200) == 0)
                            System.out.println("utworzono " + count + " obiektów");
                    });
            towar.setValues("END", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
