package week3;

public class PPJ36_c31 {
    public static void main(String[] args){
        System.out.println("========================");
        // Zadanie 1
        {
            for ( int i=0; i<10; i++){
                System.out.print( i + ", ");
            }
            System.out.println();
        }


        System.out.println("========================");
        // Zadanie 2
        {
            int wrt = 2;
            for ( int i=0; i<10; i++){
                System.out.print( wrt * i + ", ");
            }
            System.out.println();
        }


        System.out.println("========================");
        // Zadanie 3
        {
            // Pętla while sprawdza warunek przed wykonaniem pętli
            // Pętla do while sprawdza warunek po wykonaniu pętli

            int a;

            a = 3;
            while ( a > 5){
                System.out.println( a);
                a++;
            }
            System.out.println("a: " + a);

            a =3;
            do {
                System.out.println( a);
                a++;
            }while ( a > 5);
            System.out.println("a: " + a);

        }


        System.out.println("========================");
        // Zadanie 4
        {
            double sum = 1d;
            double temp = 1d;

            for ( int i = 0; i < 10; i++){
                temp = temp * 0.5;
                sum = sum + temp;
                //System.out.println("Temp: " + temp);
                System.out.println("Sum " + i + ": " + sum);
            }

        }


        System.out.println("========================");
        // Zadanie 5
        {
            for ( int i=0; i<6; i++){
                for (int j=0; j<9; j++){
                    if ((i+j)%2==0) {
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        }


        System.out.println("========================");
        // Zadanie 6
        {
            int size = 5;

            for ( int i=0; i<(2*size + 1); i++){
                for (int j=0; j<(2*size + 1); j++){
                    if ( ((i-j >= -size) && (i-j <= size)) &&  ((i+j<=3*size) && (i+j>=size)) ){
                        System.out.print("*");
                    }else{
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }


        System.out.println("========================");
        // Zadanie 7
        {
            char[] arr1 = { 'z', 'v', 'd'};
            int indexMin = 0;

            for ( int i=0; i < arr1.length; i++){
                if ( arr1[i] < arr1[indexMin]){
                    indexMin = i;
                }
            }
            System.out.println("Min index: " + indexMin);
        }


        System.out.println("========================");
        // Zadanie 8
        {
            byte[] arr1 = { 0, 1, 1, 2};
            byte[] arr2 = { 0, 1, 1, 2};
            boolean notSame = false;

            if (arr1.length == arr2.length){
                for (int i=0; i < arr1.length; i++){
                    if ( (arr1[i] != arr2[i]) && !notSame){
                        notSame = true;
                    }
                }
            }
            System.out.println("Arr1 and Arr2 are the same: " + !notSame);

        }


        System.out.println("========================");
        // Zadanie 9
       {
            //                0     1   2   3
            double[] arr11 = {11d, 10.2d, 3d, 0.5d};
            double minSum = arr11[1] + arr11[2];
            double temp;
            double num1 = 0d;
            double num2 = 0d;

            for (int i=0; i < arr11.length; i++){
                for (int j=i+1; j < arr11.length; j++){
                    temp = arr11[i] + arr11[j];
                    if (temp < 0){
                        temp *= -1d;
                    }
                    if (temp < minSum){
                        minSum = temp;
                        num1 = arr11[i];
                        num2 = arr11[j];

                    }
                }
            }
            System.out.println("Minimal sum is: " + minSum);
           System.out.println("Numbers are: " + num1 + " and " + num2);

        }




        System.out.println("========================");
        // Zadanie 10
        {
            int size = 10 + ( int)( Math.random()*10)%6;
            int[] arr1 = new int[ size];

            //WYPELNIANIE TABLICY
            for ( int i=0; i< arr1.length; i++){
                arr1[ i] = i;
                System.out.print(arr1[ i] + ", ");
            }
            System.out.println();

            // PERMUTOWANIE
            int position;
            int temp, temp2;
            for ( int i=0; i< arr1.length; i++){
                position = ( int)( Math.random()*100)%size;
                temp = arr1[ i];
                arr1[ i] = arr1[ position];
                arr1[ position] = temp;

            }

            // PERMUTACJE TABLICA
            for ( int i=0; i< arr1.length; i++){
                System.out.print( arr1[ i] + ", ");

            }
            System.out.println();

            // OBRAZEK
            for ( int i=0; i< arr1.length; i++){
                for ( int j=0; j < arr1.length; j++){
                    System.out.print( i == arr1[ j] ? "* " : ". ");
                }
                System.out.println();
            }



            System.out.println();
        }


        System.out.println("========================");
        // Zadanie 11
        {
            int[] ISBN = new int[10];
            int sum = 0;

            java.util.Scanner in = new java.util.Scanner(System.in);
            for (int i=0; i< 9; i++) {
                System.out.println("Podaj liczbę numer " + (i + 1) + "/9");
                ISBN[i] = in.nextInt();
            }

            for (int i=0; i < 9; i++){
                sum = sum + ISBN[i];
            }
            ISBN[9] = sum;
            System.out.println("Suma kontrolna: " + ISBN[9]);

        }






    }
}
