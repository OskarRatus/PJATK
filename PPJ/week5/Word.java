package week5;

public class Word {
    private char[] arr;
    private int val;

    public Word(){
        arr = new char[100];
        val = 0;
    }

    public void addChar(char x){
        // TODO dodać dynamiczne zwiekszanie tablicy
        arr[val++] = x;
    }

    public void show(){
        for (int i=0; i<val; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int length(){
        return val;
    }
}
