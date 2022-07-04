/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad5;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Author implements Runnable {
    private ArrayBlockingQueue<String> stringArrayBlockingQueue;
    private String[] stringsArray;

    public Author(String[] s){
        stringArrayBlockingQueue = new ArrayBlockingQueue<>(1);
        this.stringsArray = s;
    }

    public  String getStr() {
        String str = null;
        try {
            str =  stringArrayBlockingQueue.poll(1500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }


    @Override
    public void run() {
        for (String s : stringsArray) {
            try {
                stringArrayBlockingQueue.put(s);
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
