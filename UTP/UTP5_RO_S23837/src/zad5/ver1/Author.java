/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad5.ver1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Author implements Runnable {
    private List<String> stringList;
    private String str;
    private boolean isLocked = true;

    public Author(String[] s){
        stringList = new ArrayList<>(Arrays.asList(s));
        stringList.add(null);
    }

    public synchronized String getStr() {
        while (isLocked){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isLocked = true;
        notifyAll();
        return str;
    }

    public synchronized void setStr(String s){
        while (!isLocked){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isLocked = false;
        str = s;
        notifyAll();
    }

    @Override
    public void run() {
        for (int i = 0; i < stringList.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setStr(stringList.get(i));
        }
    }
}
