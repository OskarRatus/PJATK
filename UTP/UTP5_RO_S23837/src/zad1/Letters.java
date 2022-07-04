package zad1;

import java.util.ArrayList;

public class Letters extends Thread{
    private ArrayList<Thread> threadArrayList = new ArrayList<>();
    
    public Letters(String input){
        for (String s : input.split("")) {
            this.threadArrayList.add(new Thread("Thread " + s){
                @Override
                public void run() {
                    while (!currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(1000);
                            System.out.print(s);
                        } catch (InterruptedException e) {
                            currentThread().interrupt();
                        }
                    }

                    }
            });
        }
    }

    public Iterable<Thread> getThreads(){
        return threadArrayList;
    }

}
