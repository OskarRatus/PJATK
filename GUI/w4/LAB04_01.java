package w4;

import java.sql.Ref;

public class LAB04_01 {
    public static void main(String[] args) {
        Player p1 = new Player("ppj");                                            // tworzenie gracza ze swoim identyfikatorem


        Player p2 = new Player("gui");
        Player p3 = new Player("ppc");
//        p1.start();
//        p2.start();

        Referee ref = new Referee(10, new Player[]{p1,p2,p3});       //  arbiter ustala czas gry (w sekundach), "rejestruje" tablicę graczy

        ref.startGame();                                         // arbiter startuje swój wątek: mierzy czas oraz daje sygnał startu graczom

        try {

            ref.join();                                                                          // czekamy, aż wątek arbitra zakończy swoją pracę, tzn. po upływie określonego czasu przerywa pracę wątków wszystkich graczy

            // join() jest metodą z klasy Thread

        } catch (InterruptedException exc){

            exc.printStackTrace();

        }

        ref.result();                                                                            // arbiter ogłasza wynik gry
    }
}

class Player
        extends Thread{

    protected int num;
    protected int sum;
    protected int delay;

    public Player(String name){
        super(name);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = 0;
    }

    public int getSum() {
        return sum;
    }

    public void run(){
        while(true){
                delay = (int)(Math.random() * 5 + 1);
            try {
                this.sleep(delay * 100);
            } catch (InterruptedException e) {
                break;
            }


            num += (int)(Math.random()*100+1);
            sum += num;

            if (Thread.interrupted())
                return;
        }
    }
}

class Referee
        extends Thread{

    protected int[][] score;
    protected Player[] p;
    protected int time;

    public Referee(int time, Player[] p){
        this.time = time;
        this.p = p;
        this.score = new int[time][p.length];
    }

    public void startGame(){
        this.start();
        for (Player p0 : p)
            p0.start();


    }

    public void run(){
        System.out.println("Rozpoczęto grę");
        System.out.println("================================");
        int i = 0;

        while(i < time){
            System.out.println("Czas " + i);
            try {
                sleep(200);
                for (Player p0 : p){
                    System.out.println(" " + p0.getName()+ ": " + p0.getNum());
                    p0.setNum(0);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;

        }
        for (Player p0 : p)
            p0.interrupt();
    }

    public void result(){
        int max = 0;
        String nam = "";
        System.out.println("================================");
        for (Player p0 : p){
            System.out.println(p0.getName() + " zdobył " + p0.getSum());
            if (p0.getSum() > max){
                max = p0.getSum();
                nam= p0.getName();
            }
        }
        System.out.println("================================");
        System.out.println(nam + " wygrał!");
    }

}





