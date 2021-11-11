package w5;

public class LAB05_01 {
    public static void main(String[] args) throws InterruptedException {
        StringTask task = new StringTask("ABC", 50000);
        System.out.println("Task " + task.getState());
        task.start();
        if (args.length > 0 && args[0].equals("abort")) {
            Thread thread2 = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    task.abort();}
                );
            thread2.start();

        }

        while (!task.isDone()) {
            Thread.sleep(500);
            switch(task.getState()) {
                case RUNNING: System.out.print("R."); break;
                case ABORTED: System.out.println(" ... aborted."); break;
                case READY: System.out.println(" ... ready."); break;
                default: System.out.println("uknown state");
            }

        }
        System.out.println("Task " + task.getState());
        System.out.println(task.getResult().length());
        System.out.println(task.getResult().length());
    }
}

class StringTask implements Runnable {
    public enum TaskState{
        CREATED, RUNNING, ABORTED, READY
    }

    protected String str;
    protected String strOut;
    protected int num;
    protected Thread thread;
    protected TaskState myState;

    StringTask(String string, int num) {
        this.str = string;
        this.num = num;
        myState = TaskState.CREATED;
    }

    @Override
    public void run() {
        byte[] tab = str.getBytes();
        byte[] tmp = new byte[str.length()];

        for (int i=0; i < tab.length; i++) {
            tmp[tab.length - i - 1] = tab[i];
        }
        str = tmp.toString();

        for (int i = 0; i < num; i++) {
            if (thread.isInterrupted()){
                return;
            }
            strOut += str;
        }
        myState = TaskState.READY;

    }

    public String getResult() {
        return strOut;
    }

    public TaskState getState() {return myState;}

    public void start(){
        thread = new Thread(this);
        myState = TaskState.RUNNING;
        thread.start();
    }

    public void abort(){
        thread.interrupt();
        myState = TaskState.ABORTED;

    }

    public boolean isDone(){
        return myState == TaskState.READY || myState == TaskState.ABORTED;
    }
}
