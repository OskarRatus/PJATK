package w2;

public class LAB02_01 {
    public static void main(String[] args) {
        {
            Figura fig[] = new Figura[2];
            fig[0] = new Kolo(10, 10, 5);                        // położenie koła = srodek = (10,10), promień = 5
            fig[1] = new Prostokat(20, 20, 15, 10);    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10

            // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
            // a nie z klasy Figura
            for (Figura f : fig)              // pętla for-each
                System.out.println(f);        // System.out.println(f.toString());

            fig[0].pozycja(12, 12);
            fig[1].pozycja(25, 30);

            //========================================
            // ZADANIE 4
            System.out.println(fig[0].Pole());
            System.out.println(fig[0].Obwod());

            System.out.println(fig[1].Pole());
            System.out.println(fig[1].Obwod());

        }
    }
}
// ZADANIE 4
interface Obliczenie{
    public double Pole();
    public double Obwod();
}

// ZADANIE 3 i 4
abstract class Figura implements Obliczenie{
    int x;
    int y;

    public Figura(int x, int y){
        this.x = x;
        this.y= y;
    }

    protected abstract String nazwa();
    protected abstract void pozycja(int x, int y);

    @Override
    public String toString() {
        return "Figura{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Kolo extends Figura{

    int r;

    public Kolo(int x, int y, int r){
        super(x,y);
        this.r = r;
    }

    @Override
    protected String nazwa() {
        return "Kolo";
    }

    @Override
    protected void pozycja(int x, int y) {
        double d = Math.sqrt((Math.pow((this.x - x),2) + Math.pow((this.y - y),2)));
        if (d < r){
            System.out.println("Punkt (" + x + ", " + y + ") znajduje sie wewnatrz kola");
        } else {
            System.out.println("Punkt (" + x + ", " + y + ") znajduje sie na zewnatrz kola");
        }
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    @Override
    public double Pole() {
        return (double)(Math.PI * r * r);
    }

    @Override
    public double Obwod() {
        return (double)(2 * Math.PI * r);
    }
}


class Prostokat extends Figura{

    int width;
    int height;

    public Prostokat(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    protected String nazwa() {
        return "Prostokat";
    }

    @Override
    protected void pozycja(int x, int y) {
        if(x < (this.x + this.width) && y < (this.y - this.height)){
            System.out.println("Punkt (" + x + ", " + y + ") znajduje sie wewnatrz prostokata");
        } else {
            System.out.println("Punkt (" + x + ", " + y + ") znajduje sie na zewnatrz prostokata");
        }
    }

    @Override
    public String toString() {
        return "Prostokat{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public double Pole() {
        return (double)(width * height);
    }

    @Override
    public double Obwod() {
        return (double)(2*width + 2*height);
    }
}