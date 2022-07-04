package zad4;

public class Consumer extends Thread {
    private Towar towar;

    public Consumer(Towar towar) {
        this.towar = towar;
    }

    @Override
    public void run() {
        Double cumSum = 0.;
        int count = 0;
        for (String last = towar.readId(); !last.equals("END"); last = towar.readId()) {
            cumSum += towar.getWaga();
            if ((++count % 100) == 0)
                System.out.println("policzono wage " + count + " towarów");
        }
        System.out.println(cumSum);
    }
}
