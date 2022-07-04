package zad4;

public class Main {

    public static void main(String[] args) {
        Towar t = new Towar();
        Thread A = new Consumer(t);
        Thread B = new Producer(t);
        A.start();
        B.start();
    }

}