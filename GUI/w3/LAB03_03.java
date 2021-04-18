package w3;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LAB03_03 {
    public static void main(String[] args) {
        List<Spiewak2> lst = new ArrayList<Spiewak2>();




//1
        lst.add(new Spiewak2("Darrey") {
            @Override
            protected String spiewaj() {
                return "eeae";
            }
        });
//2
        lst.add(new Spiewak2("Darrey") {
            @Override
            protected String spiewaj() {
                return "bebe";
            }
        });

//3
        lst.add(new Spiewak2("Houston") {
            @Override
            protected String spiewaj() {
                return "a4iBBiii";
            }
        });
//4
        lst.add(new Spiewak2("Carrey") {
            @Override
            protected String spiewaj() {
                return "oaooooooooooo";
            }
        });
//5
        lst.add(new Spiewak2("Madonna") {
            @Override
            protected String spiewaj() {
                return "aAa";
            }
        });

        System.out.println("Spiewacy przed sortowaniem:");
        for (Spiewak2 f: lst)
            System.out.println(f);

        Collections.sort(lst);

        System.out.println("\nSpiewacy po sortowaniem:");
        for (Spiewak2 f: lst)
            System.out.println(f);

    }

}

abstract class Spiewak2
        extends Spiewak
        implements Comparable<Spiewak>{

    protected Spiewak2(String nazwisko) {
        super(nazwisko);
    }

    public int compareTo(Spiewak s){
        if (this.loudness() < s.loudness())
            return 1;
        else if (this.loudness() > s.loudness())
            return -1;
        else
            if (this.nazwisko.compareTo(s.nazwisko) < 0)
                return 1;
            else if (this.nazwisko.compareTo(s.nazwisko) > 0)
                return -1;
            else
                if (this.number < s.number)
                    return 1;
                else
                    return -1;


    }

}
