/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Purchase {
    private String id_klienta;
    private String nazwisko ;
    private String imie;
    private String nazwa_towaru;
    private double cena;
    private double zakupiona_ilość;
    private double koszt;
    private String linia;

    public Purchase(String input) {
        String[] tmp = input.split(";");
        this.id_klienta = tmp[0];
        String[] imieNazwisko = tmp[1].split(" ");
        this.nazwisko = imieNazwisko[0];
        this.imie = imieNazwisko[1];
        this.nazwa_towaru = tmp[2];
        this.cena = Double.parseDouble(tmp[3]);
        this.zakupiona_ilość = Double.parseDouble(tmp[4]);
        this.koszt = this.cena * this.zakupiona_ilość;
        this.linia = input;

    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id_klienta='" + id_klienta + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwa_towaru='" + nazwa_towaru + '\'' +
                ", cena=" + cena +
                ", zakupiona_ilość=" + zakupiona_ilość +
                ", linia='" + linia + '\'' +
                '}';
    }

    public double getKoszt() {
        return koszt;
    }

    public String getId_klienta() {
        return id_klienta;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwa_towaru() {
        return nazwa_towaru;
    }

    public double getCena() {
        return cena;
    }

    public double getZakupiona_ilość() {
        return zakupiona_ilość;
    }

    public String getLinia() {
        return linia;
    }
}
