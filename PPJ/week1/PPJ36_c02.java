package week1;

public class PPJ36_c02 {
    public static void main(String[] args){
    //System.out.println(54 & 2); //AND - koniunkcja
    //System.out.println(36 | 8); //OR
    //System.out.println(36 ^ 8); //XOR
    //System.out.println(45 >> 1); //PRZE

    //System.out.println(0B1010); // 10 binarnie
    //System.out.println(012); // 10 oktalnie
    //System.out.println(0xA); // 10 heksalnie

    // Jeżeli chcemi sprawdzic czy na pozycji jest 1 uzywamy AND
    // Jezeli chcemy zeby na pozycji zostal 1  uzywamu OR

    
// Konwersja na bin
    System.out.print((59>>7) & 1);
    System.out.print((59>>6) & 1);
    System.out.print((59>>5) & 1);
    System.out.print((59>>4) & 1);
    System.out.print((59>>3) & 1);
    System.out.print((59>>2) & 1);
    System.out.print((59>>1) & 1);
    System.out.println((59>>0) & 1);

// Dodawanie na bitach
    System.out.println(59 ^ 24); //35
    System.out.println((59 & 24) << 1); //48

    System.out.println(35 ^ 48); //19
    System.out.println((35 & 48) << 1); //64

    System.out.println(19 ^ 64); //83
    System.out.println((19 & 64) << 1); //0 KONIEC 
    

    

    }
}
