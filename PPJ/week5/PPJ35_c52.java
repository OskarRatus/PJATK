package week5;

public class PPJ35_c52 {
    public static void main(String[] args){
        //================================== Zadanie 1
        {
            Kwadrat test1 = new Kwadrat(12);
            System.out.println(test1.toString());
        }


        //================================== Zadanie 2
        {
            Walec test2 = new Walec(2, 4);
            System.out.println(test2.toString());
        }


        //================================== Zadanie 3
        {
            Kwadrat test1 = new Kwadrat(12);
            KulaW test3 = new KulaW(test1);
            System.out.println(test3.toString());

            Walec test2 = new Walec(2, 4);
            KulaW test4 = new KulaW(test2);
            System.out.println(test4.toString());
        }


        //================================== Zadanie 4
        {
            Kwadrat test1 = new Kwadrat(9);
            Walec test2 = new Walec(2, 3);

            KulaNa spSq = new KulaNa(test1);
            System.out.println(spSq.toString());

            KulaNa spCyl = new KulaNa(test2);
            System.out.println(spCyl.toString());

        }


        //================================== Zadanie 5
        {
            Word tab = new Word();
            tab.addChar('a');
            tab.addChar('b');
            tab.show();
            System.out.println(tab.length());
        }


        //================================== Zadanie 6
        {
            Pomegranate test = new Pomegranate();
            test.name = "Pomegranate";
            test.seedCount = 12;

            Fruit test2 = new Fruit();
            test2.name = "Apple";

            System.out.println(test2.toString());
            System.out.println(test.toString());

        }
    }
}
