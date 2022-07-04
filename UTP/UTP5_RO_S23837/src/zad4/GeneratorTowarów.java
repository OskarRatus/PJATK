package zad4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GeneratorTowarów {
    public static void main(String[] args) {
        double waga;
        int id = 0;
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("../Towary.txt"));
            System.out.println(Paths.get("..\\Towary.txt").toRealPath());
            for (int i = 0; i < 10_000; i++) {
                waga = Math.round(Math.random() * 100.) / 100.;
                id++;
                bufferedWriter.write(id + " " + waga + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
