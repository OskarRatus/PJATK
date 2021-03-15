package week4;

// Zestaw 8
public class PPJ36_c42 {
    public static void main(String[] argsd){
        System.out.println("======================== Zadanie 1");
        // Zadanie 1
        {
            MethodCurrier test = new MethodCurrier();

            System.out.println(" IN int ");
            int val1 = 12;
            test.setValue(val1);
            System.out.println();

            System.out.println(" IN float ");
            float val2 = (float)12.12;
            test.setValue(val2);
            System.out.println();

            System.out.println(" IN char ");
            char val3 = (char)'a';
            test.setValue(val3); // out -> int
            System.out.println();

            System.out.println(" IN byte ");
            byte val4 = (byte)12;
            test.setValue(val4); // out -> int
            System.out.println();

            // Decyzja jest podejmowana na podstawie parametru dostarczonego do metody, wybierany jest najbliższy (najbardziej podobny) typ do wskazanego

        }


        System.out.println("======================== Zadanie 2");
        // Zadanie 2
        {
            Number test2 = new Number();
            test2.setValue(12);
            test2.showValue();

            MethodCurrier test3 = new MethodCurrier();
            test3.setValue(test2);

        }


        System.out.println("======================== Zadanie 3");
        // Zadanie 3
        {
            Person person = new Person();
            person.name = "Oskar";
            person.surname = "Ratus";
            person.bDay = 12;

            System.out.println(person.name);
        }


        System.out.println("======================== Zadanie 4");
        // Zadanie 4
        {
            Person person = new Person();
            person.show();
        }


        System.out.println("======================== Zadanie 5");
        // Zadanie 5
        {
            Cplx test1 = new Cplx(1,2);
            Cplx test2 = new Cplx(2,4);
            Cplx test3 = new Cplx(1,-5);

            System.out.printf("Liczba 1 = ");
            test1.show();
            System.out.printf("Liczba 2 = ");
            test2.show();
            System.out.printf("Liczba 3 = ");
            test3.show();

            System.out.println("Liczba 1 + Liczba 2");
            test1.add(test2);
            test1.show();

            System.out.println("Liczba 1 - Liczba 2");
            test1.sub(test2);
            test1.show();

            System.out.println("Liczba 1 * Liczba 3");
            test1.mul(test3);
            test1.show();

            System.out.println("Re(Liczba 1) + 1 ");
            test1.inc();
            test1.show();



        }

    }



}

