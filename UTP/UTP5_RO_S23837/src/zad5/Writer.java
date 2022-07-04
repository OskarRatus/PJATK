/**
 *
 *  @author Ratus Oskar S23837
 *
 */

package zad5;

public class Writer implements Runnable {
    private Author author;

    public Writer(Author a){
        this.author = a;
    }

    @Override
    public void run() {
        String s = author.getStr();
        while(s != null) {
            System.out.println(s);
            s = author.getStr();
        }
    }
}
