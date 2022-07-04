package zad1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TravelData {
    private List<Trip> trips = new ArrayList<>();

    public TravelData(File dataDir) {
        try {
            Files.walk(dataDir.toPath())
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            Files.readAllLines(file).stream().forEach(line -> {
                                trips.add(new Trip(line.split("\\t")));
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
        return trips.stream().map(trip -> trip.makeLocal(locale,dateFormat)).collect(Collectors.toList());
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
