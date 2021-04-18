package w3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LAB03_01 {
    public static void main(String[] args) {

        List<Figura> listaFig = new ArrayList<Figura>();

        // dodawanie figur do listy figur za pomoca metody add z List
        listaFig.add(new Prostokat(1,1,4,9));
        listaFig.add(new Kolo(1,2,5));
        listaFig.add(new Prostokat(2,2,6,6));

        System.out.println("Figury przed sortowaniem:");
        for (Figura f: listaFig)
            System.out.println(f);

        // sortowanie listy figur
        Collections.sort(listaFig);

        System.out.println("Figury po sortowaniu:");
        for (Figura f: listaFig)
            System.out.println(f);

    }


    interface Obliczenie{
        public double pole();
        public double obwod();
    }

    abstract static class Figura implements Obliczenie, Comparable<Figura> {
        int x;
        int y;

        static int count =0;
        int number = count;

        public Figura(int x, int y){
            this.x = x;
            this.y= y;
            count++;
            this.number = count;
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

        @Override
        public int compareTo(Figura f){
            if (this.pole() - f.pole() < 0)
                return -1;
            else if (this.pole() - f.pole() > 0)
                return 1;
            else {
                if (this.obwod() - f.obwod() < 0)
                    return -1;
                else if (this.obwod() - f.obwod() > 0)
                    return 1;
                else {
                    if (this.number - f.number < 0)
                        return -1;
                    else
                        return 1;
                }
            }
        }

    }

    static class Kolo extends Figura {

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
        public double pole() {
            return (double)(Math.PI * r * r);
        }

        @Override
        public double obwod() {
            return (double)(2 * Math.PI * r);
        }
    }

    static class Prostokat extends Figura {

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
        public double pole() {
            return (double)(width * height);
        }

        @Override
        public double obwod() {
            return (double)(2*width + 2*height);
        }
    }
}

