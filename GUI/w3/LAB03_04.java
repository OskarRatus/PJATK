package w3;

import java.util.Iterator;


public class LAB03_04 {
    public static void main(String [] args)
    {
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        // iteracja po znakach napisu,
        // domyślnie zaczynając od pierwszego znaku (o indeksie 0)
        // i z krokiem iteracji = 1
        for (char z: napis)
            System.out.print(z + " ");

        System.out.println();

        napis.ustawPoczatek(2);     // ustawienie początku iteracji (tu: 2-gi znak, o indeksie 2)
        napis.ustawKrok(3);         // ustawienie kroku iteracji (tu: co 3-ci znak)

        // iteracja po znakach napisu,
        // od ustalonego znaku, z określonym krokiem
        for (char z: napis)
            System.out.print(z + " ");

        System.out.println();

	/*<-  co tu trzeba napisać w wywołaniu metody forEach z argumentem będącym lambda-wyrażeniem
	      w celu wyświetlenia znaków napisu (w postaci małych liter) zgodnie z iteracją
*/
        napis.forEach(x -> {
            System.out.print( x.toString().toLowerCase()); // czy tutaj x jest elementem z iterator ??
        });


    }

}

class IterNap implements Iterable<Character> {

    protected int start;
    protected int step;
    protected int len;
    protected String str;
    protected char c;

    public IterNap(String sentence) {
        this.len = sentence.length();
        this.str = sentence;
        this.start = 0;
        this.step = 1;
    }

    @Override
    public Iterator<Character> iterator() { //dlaczego tutaj nie moze byc char ???
        return new Iterator<Character>() {
            int index = start;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public Character next() {
                c = str.charAt(index);
                index += step;
                return c;
            }
        };
    }

    public void ustawPoczatek(int num) {
        this.start = num;
    }

    public void ustawKrok(int num) {
        this.step = num;
    }
}

