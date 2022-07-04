package zad1;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Database {
    private Connection connection;
    private Statement statement;
    private TravelData travelData;

    public Database(String url, TravelData travelData) {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            this.travelData = travelData;
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void create() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS Trips;");
            statement.execute("CREATE TABLE IF NOT EXISTS Trips (" +
                    " Locale TEXT," +
                    " Country TEXT," +
                    " DateFrom DATE ," +
                    " DateTo DATE," +
                    " Place TEXT," +
                    " Price DOUBLE," +
                    " Currency TEXT);");

            for (Trip trip : travelData.getTrips()) {
                String tmpLocaleToDB = trip.getLocale().toLanguageTag();
                addToTripsTable(
                        tmpLocaleToDB,
                        trip.getCntryName(),
                        df.format(trip.getDateStart()),
                        df.format(trip.getDateEnd()),
                        trip.getPlace(),
                        trip.getPrice(),
                        trip.getCurrency()
                );
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void addToTripsTable(String Locale, String Country, String DateFrom, String DateTo, String Place, Double Price, String Currency){
        try {
            statement = connection.createStatement();
            statement.execute("INSERT INTO Trips " +
                    "(Locale, Country, DateFrom, DateTo, Place, Price, Currency) VALUES ('" +
                    Locale      + "', '" +
                    Country     + "', '" +
                    DateFrom    + "', '" +
                    DateTo      + "', '" +
                    Place       + "', '" +
                    Price       + "', '" +
                    Currency    + "');"
            );
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String[][] makeToLocalArray(List<Trip> list, String locale){
        String[][] stringArr;

        stringArr = new String[list.size()][7];
        int i =0;
        for (Trip t : list) {
            String[] tmpString = t.makeLocal(locale, "yyyy-MM-dd").split("\\t");
            stringArr[i++] = tmpString;
        }

        return  stringArr;
    }

//    private String[][] retriveFromDB(String locale){
    public List<Trip> retriveFromDB(){
        List<Trip> list= new ArrayList<>();

        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            statement.execute("SELECT * FROM Trips;");
            resultSet = statement.getResultSet();


            while (resultSet.next()){
                String tmpLocale = resultSet.getString(1);
                String tmpCountry = resultSet.getString(2);
                String tmpDateFrom = resultSet.getString(3);
                String tmpDateTo = resultSet.getString(4);
                String tmpPlace = resultSet.getString(5);
                String tmpPrice = resultSet.getString(6);
                String tmpCurrency = resultSet.getString(7);

                String[] finalStringArr = {tmpLocale, tmpCountry, tmpDateFrom, tmpDateTo, tmpPlace, tmpPrice, tmpCurrency};
                list.add(new Trip(finalStringArr));
            }


            statement.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void showGui() {
        new View(this, new String[]{"Państwo", "DataOd", "DataDo", "Miejsce", "Cena", "Waluta"});
    }
}
