package week2;


public class PPJ36_c22 {
    public static void main(String[] args){

        // Zadanie 1
        /* Dana jest wartosc 1517. Przedstaw jej zapis w postaci literału binarnego,
            oktalnego i heksadecymalnego. Dla weryfikacji przygotuj program wyswietlajacy wartosci
            tych literałów na ekranie. */
        System.out.println("\n Zadanie 1");
        System.out.println("Decymalnie: " + 1517);
        System.out.println("Binarnie: " + 0b10111101101);
        System.out.println("Oktalnie: " + 02755);
        System.out.println("Heksadecymalnie: " + 0x5ED);


        // Zadanie 2
        /*Zadeklaruj i zainicjuj dwie zmienne typu byte z których pierwsza bedzie
            miała wartosc 219. Nastepnie wylicz wartosc drugiej zmiennej tak aby rezultatem
            alternatywy rozłacznej (XOR) obu zmiennych była wartosc 28. */
        System.out.println("\n Zadanie 2");
        int zmienna1 = 219; // unsigned (-37)
        int zmienna2 = 199; // dla unsigned wartosci >127 przyjmują wartości ujemne
        System.out.println(zmienna1 ^ zmienna2);
        System.out.println("Szukana liczba to: " + zmienna2);


        // Zadanie 3
        /* Zadeklaruj zmienna typu short i zainicjuj wartoscia 22357. Nastepnie wykorzystujac
            operatory bitowe sprawdz: */
        System.out.println("\n Zadanie 3");
        short zmienna3 = 22357;

        //pkt.1.
        /* czy istnieja przynajmniej dwa bity na nieparzystych pozycjach (poczynajac od
            bitu0), których wartosc jest równa 0. */
        System.out.println("\n pkt.1");

        //pkt.2.
        /* czy alternatywa bitowa uzytej w zadaniu wartosci z reszta z dzielenia przez 21
            jest wartoscia nieparzysta */
        System.out.println("\n pkt.2");
        short wynik = (short)(zmienna3 % 21);
        wynik = (short)(zmienna3 | wynik);
        System.out.println("Czy nieparzysta?: " + ((wynik & 0b1) == 0b1));



    }
}

