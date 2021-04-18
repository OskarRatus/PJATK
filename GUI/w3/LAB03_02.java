package w3;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LAB03_02 {
    public static void main(String[] args) {
        Spiewak s1 = new Spiewak("Dietrich"){
            @Override
            protected String spiewaj() {return "oooooooooooo";}
        };

        Spiewak s2 = new Spiewak("Piaf"){
            @Override
            protected String spiewaj() {return "a4iBBiii";}
        };

        Spiewak s3 = new Spiewak("Adele"){
            @Override
            protected String spiewaj() {
                return "aAa";
            }
        };

        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}

abstract class Spiewak{
    protected String nazwisko;
    protected int number;
    protected static int count = 0;

    protected Spiewak(String nazwisko){
        this.nazwisko = nazwisko;
        count++;
        this.number =count;
    }

    protected abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + number + ")" +
                " " + nazwisko + ": " +
                this.spiewaj();
    }

    protected static Spiewak najglosniej(Spiewak[] s){
        int max = 0;
        Spiewak out = null;
        for (Spiewak x : s)
            if (max < x.loudness()) {
                max = x.loudness();
                out = x;
            }
            return out;
    }

    protected int loudness(){
        return (int) this.spiewaj().toLowerCase().replaceAll("\\d","").chars().distinct().count();

    }


}
