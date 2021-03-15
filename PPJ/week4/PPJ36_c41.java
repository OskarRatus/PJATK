package week4;

import java.util.Arrays;

public class PPJ36_c41 {
    public static void main(String[] args) {
        System.out.println("======================== Zadanie 1");
        // Zadanie 1
        {
            int[] arr1 = {1, 2, 3, 4, 4, 3, 2, 1};
            boolean isSame = true;

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr1[arr1.length - 1 - i])
                    isSame = false;

            }
            System.out.println(isSame);
        }


        System.out.println("======================== Zadanie 2");
        // Zadanie 2
        {
            long[] arr1 = new long[5];
            arr1[0] = 1;
            for (int i = 1; i < arr1.length; i++) {
                arr1[i] = arr1[i - 1] + 1;
            }

            boolean state = false;
            int count = 0;
            while (!state) {
                count++;
                state = true;
                int rand1 = (int) (Math.random() * arr1.length);
                int rand2 = (int) (Math.random() * arr1.length);

                long temp = arr1[rand1];
                arr1[rand1] = arr1[rand2];
                arr1[rand2] = temp;

                for (int i = 0; i < arr1.length - 1; i++) {
                    if (arr1[i] + 1 == arr1[i + 1]) {
                        state = false;
                    }
                }

            }
            System.out.println("Tablica " + Arrays.toString(arr1));
            System.out.println("Counter " + count);
        }


        System.out.println("======================== Zadanie 3");
        // Zadanie 3

        {
            int[] arr1 = { 1, 7, 3, 2, 5};
            double[] arr2 = { 5d, 8d, 9d, 10d, 11d};

            double sum=0d;
            double tempMin = 9999d;
            int tempVal = 0;
            for (int i=1; i< arr1.length; i++){
                sum = (double)(arr1[i] + arr2[i]);
                while (tempMin > sum){
                    tempMin = sum;
                    tempVal = arr1[i-1];
                    arr1[i-1] = arr1[i];
                    arr1[i] = tempVal;

                }
            }

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
        }



        System.out.println("======================== Zadanie 4");
        // Zadanie 4
        {
            int[][] tab = {{1, 0, 0, 0, 0,}, {0, 1, 0, 0,}, {0, 0, 1}};


            // liczenie wymiaru splaszczonej tablicy
            int count = 0;
            for (int i = 0; i < tab.length; i++) {
                count += tab[i].length;
            }
            int[] arr = new int[count];

            int i = 0;
            for (int x = 0; x < tab.length; x++) {
                for (int y = 0; y < tab[x].length; y++) {
                    arr[i] = tab[x][y];
                    i++;
                }
            }
            System.out.println(Arrays.toString(arr));
        }


        System.out.println("======================== Zadanie 5");
        // Zadanie 5

        {
            int[] arr1 = new int[5];
            int[] arr2 = new int[6];
            int[] arr3 = new int[8];

            // Populate table
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (int) (Math.random() * 10);
                ;
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (int) (Math.random() * 10);
                ;
            }
            for (int i = 0; i < arr3.length; i++) {
                arr3[i] = (int) (Math.random() * 10);
                ;
            }

            // Initialize 2D array
            int[][] arr4 = new int[3][];
            arr4[0] = new int[arr1.length];
            arr4[1] = new int[arr2.length];
            arr4[2] = new int[arr3.length];

            for (int i = 0; i < arr4.length; i++) {
                for (int j = 0; j < arr4[i].length; j++) {
                    if (i == 0)
                        arr4[i][j] = arr1[j];
                    if (i == 1)
                        arr4[i][j] = arr2[j];
                    if (i == 2)
                        arr4[i][j] = arr3[j];
                }
            }
            for (int[] row : arr4)
                System.out.println("2D array: " + Arrays.toString(row));
        }


        System.out.println("======================== Zadanie 6");
        // Zadanie 6
        {
            float[][] arr = new float[8][8];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = (float) (Math.random() * 10);
                }
            }

            float sumLeft = (float) 0;
            for (int i = 0; i < arr.length; i++) {
                sumLeft += arr[i][i];
            }
            float sumRight = (float) 0;
            for (int i = 0; i < arr.length; i++) {
                sumRight = arr[i][arr[i].length - 1 - i]; //PRZEKATNA
            }
            System.out.println("Prawa suma: " + sumRight);
            System.out.println("Lewa suma: " + sumLeft);
        }


        System.out.println("======================== Zadanie 7");
        // Zadanie 7

        {
            int[][] tab = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };

            int count = 0;
            for (int i = 0; i < tab.length; i++) {
                count += tab[i].length;
            }

            int[] resTab = new int[count];
            int x = 0;
            int y = 0;
            resTab[0] = tab[0][0];

            for (int i=1; i<count; i++){
                if (i < 4){
                    resTab[i] = tab[x][++y];
                } else if (i < 7){
                    resTab[i] = tab[++x][y];
                } else if (i < 10){
                    resTab[i] = tab[x][--y];
                } else if (i < 12){
                    resTab[i] = tab[--x][y];
                } else if (i < 14) {
                    resTab[i] = tab[x][++y];
                } else if (i < 15) {
                    resTab[i] = tab[++x][y];
                } else if (i < count) {
                    resTab[i] = tab[x][--y];
                }
            }

            System.out.println(Arrays.toString(resTab));


        }



        System.out.println("======================== Zadanie 8");
        // Zadanie 8
        {
            show(12);
        }


        System.out.println("======================== Zadanie 9");
        // Zadanie 9
        {
            int wrt = 5;
            modifyValue(wrt);
            System.out.println("Wart wrt po metodzie: " + wrt);
            //zmienna jest modyfikowana lokanie w metodzie

        }


        System.out.println("======================== Zadanie 10");
        // Zadanie 10
        {
            System.out.println(findMax(120, 100, 200));

        }


        System.out.println("======================== Zadanie 11");
        // Zadanie 11
        {
            char[] arr = {'A', 'l', 'a', ' ', 'm', 'a', ' ', 'k', 'o', 't', 'a'};
            countChar(arr);
        }


        System.out.println("======================== Zadanie 12");
        // Zadanie 12
        {
            int[] arr1 = new int[3];
            int[] arr2 = new int[6];

            // Populate table
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (int) (Math.random() * 10);
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (int) (Math.random() * 10);
            }

            int[] tab;
            tab = zad12(arr1, arr2, -1);

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(tab));


        }



    }

    // Zadanie 8
    public static void show(int x) {
        System.out.println(" Podana liczba  to: " + x);
    }


    // Zadanie 9
    public static void modifyValue( int x){
        System.out.println("Wart przed: " + x);
        x *= 5;
        System.out.println("Wart po: " + x);
    }


    // Zadanie 10
    public static int findMax( int x, int y, int z){
        if ( x>y && x>z)
            return x;
        else
            if (y > z)
                return y;
            else
                return z;
    }

    // Zadanie 11
    public static void countChar( char[] tab){
        int k = 0;
        boolean isMatch = false;
        int[] tabCount = new int[tab.length];
        char[] tabChar = new char[tab.length];

        // Count occurrences
        for (char c : tab) {
            for (int j = 0; j < tabChar.length && !isMatch; j++) {
                if (c == tabChar[j]) {
                    tabCount[j]++;
                    isMatch = true;
                }
            }
            if (!isMatch) {
                tabChar[k] = c;
                tabCount[k]++;
                k++;
            } else {
                isMatch = false;
            }
        }

        // Print result
        System.out.println(Arrays.toString(tab));
        for (int i=0; i < k; i++){
            System.out.println(tabChar[i] + " : " + tabCount[i]);
        }

    }


    public static int[] zad12(int[] tab1, int[] tab2, int par){
        int len = tab1.length < tab2.length ? tab1.length : tab2.length;
        int len2 = tab1.length > tab2.length ? tab1.length : tab2.length;
        int[] tempTab = new int[0];

        if (tab1.length == tab2.length){
            tempTab = new int[0];
        }else if  (par < 0){
            tempTab= new int[len];
            for (int i=0; i<len; i++){
                tempTab[i] = tab1[i] + tab2[i];
            }
        } else if (par >= 0) {
            tempTab = new int[len2 - len];
            for (int i = 0; i < tempTab.length; i++) {
                tempTab[i] = tab1.length > tab2.length ? tab1[i + len] : tab2[i + len];
            }
        }

        return tempTab;
    }


}


