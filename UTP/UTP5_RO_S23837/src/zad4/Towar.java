package zad4;

public class Towar {
    private Double waga;
    private String id;
    private boolean isLocked = true;

    public synchronized Double getWaga() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isLocked = true;
        notifyAll();
        return waga;
    }

    public synchronized String readId() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isLocked = false;
        notifyAll();
        return id;
    }


    public synchronized void setValues(String id, Double waga) {
        while (!isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        isLocked = false;
        this.waga = waga;
        this.id = id;
        notifyAll();
    }


}
