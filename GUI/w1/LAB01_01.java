package w1;

public class LAB01_01 {
    public static void main(String[] args) {
        Muzyk[] muzycy = {new Skrzypek("Aleks", 2),    // Imie, czas wystapienia (w godz.)
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)};
        for (Muzyk m : muzycy)
            System.out.println("w1.Muzyk: " + m.imie() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));    // muzyk otrzymujący najwyższe honorarium za występ
    }
}



abstract class Muzyk {

    private String imie;
    private double czas;

    // konstruktor
    protected Muzyk(String imie, double czas) {
        this.imie = imie;
        this.czas = czas;
    }

    // metoda getter
    protected String imie() {
        return imie;
    }

    // metoda getter
    protected double czas() {
        return czas;
    }

    // metody abstrakcyjne
    abstract protected String instrument();
    abstract protected int stawka();


    @Override
    public String toString() {
        return "w1.Muzyk{" +
                "imie='" + imie + '\'' +
                ", czas=" + czas +
                '}';
    }

    public static Muzyk maxHonorarium(Muzyk[] muzycy)
    {
        double max = 0;
        Muzyk out = null;
        for (Muzyk m : muzycy){
            double tmp = m.czas() * m.stawka();
            if (tmp > max){
                max = tmp;
                out = m;
            }
        }
        return out;

    }

}

// podklasa dziedzicząca po klasie abstrakcyjnej
class Flecista extends Muzyk {

    // konstruktor
    public Flecista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Flet";
    }

    @Override
    public int stawka() {
        return 300;
    }
}

class Skrzypek extends Muzyk {

    // konstruktor
    public Skrzypek(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Skrzypce";
    }

    @Override
    public int stawka() {
        return 200;
    }
}

class Wiolonczelista extends Muzyk {

    // konstruktor
    public Wiolonczelista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Wiolonczela";
    }

    @Override
    public int stawka() {
        return 250;
    }
}
