package week2;


public class PPJ36_c21 {
    
    public static void main(String[] args){

    // Zadanie1
    System.out.println("\n Zadanie1");
    int liczba = 16;
    System.out.println((liczba & 0b00001) == 0b00001);
    //lub
    //System.out.println((liczba >> 0) == 0b00001);

    System.out.println((liczba & 0b10000) == 0b10000);
    //lub
    //System.out.println((liczba >> 5) == 0b10000);
    
    // Zadanie2
    System.out.println("\n Zadanie2");
    int zmienna = 1;
    System.out.println(zmienna);

    // Zadanie3
    System.out.println("\n Zadanie3");
    int a123 = 1;
    //int 1abc = 2;
    //int @abc = 3;
    //int static = 4;
    //int null = 5;

    // Zadanie4
    System.out.println("\n Zadanie4");
    char charValue = 'a';
    char charvalue = 'b';
    //powinien sie skompilowac
    System.out.println(charValue - charvalue);

    // Zadanie5
    System.out.println("\n Zadanie5");
    boolean boolean1 = true;
    boolean boolean2 = true;
    //1 false AND 
    System.out.println((boolean1 && !boolean2) || (boolean2 && !boolean1));

    // Zadanie6
    System.out.println("\n Zadanie6");
    int x = 2 * ((5 + 3) * 4 - 8);
    System.out.println(x);


    // Zadanie 7
    System.out.println("\n Zadanie7");
    //java . util . Scanner in = new java . util . Scanner ( System . in ) ;
    //int studentId = in . nextInt ( ) ; //3
    //System.out.println("Hello, s" + studentId);

    // Zadanie 8
    System.out.println("\n Zadanie8");
    int liczba2 = 10;
    int liczba3 = 3;
    int wynik = liczba2%liczba3;
    System.out.println((liczba2/liczba3) + " reszty " +wynik);

    // Zadanie 9
    System.out.println("\n Zadanie9");
    boolean czyPada = true;
    if(czyPada){
        int liczba4 = 5;
        System.out.println("Zainicjowana liczba to: " + liczba4);
    } else {
        int liczba4 = 8;
        System.out.println("Zainicjowana liczba to: " + liczba4);
    }

    // Zadanie10
    System.out.println("\n Zadanie10");
    boolean czySwieciSlonce = true;
    czyPada = false;
    if((czyPada) && (!czySwieciSlonce)){
        System.out.println("plucha");
    } else {
        if((czyPada) && (czySwieciSlonce)){
            System.out.println("tecza");
        }else{
            if((!czyPada) && (czySwieciSlonce)){
                System.out.println("slonecznie");
            }else{
                System.out.println("pochmurno");
            }
        }
    }

    /*
    if(czyPada)
        if(czySwieciSlonce)
            sout();
        else
            sout();
    else
        sout();
    */
    

        
    // Zadanie11
    System.out.println("\n Zadanie11");

    czyPada = Math.random() < 0.5 ? true : false;
    byte bitWart = 0;

    /*
    if(czyPada)
        if(czySwieciSlonce)
            bitWart = (byte) (0b11);
        else
            bitWart = (byte) 0b01;
    else
        if(czySwieciSlonce)
            bitWart = (byte) 0b10;
    */

    if(czyPada)
        bitWart = (byte) (bitWart | 0b01);

    if(czySwieciSlonce)
        bitWart = (byte) (bitWart | 0b10);


    System.out.println(bitWart);

    switch (bitWart){
        case 0b11:
            System.out.println("Jest tecza");
            break;
        case 0b10:
            System.out.println("Jest slonecznie");
            break;
        case 0b01:
            System.out.println("Jest plucha");
            break;
        case 0b00:
            System.out.println("Jest pochmurno");
            break;
    }
    

    }
}
