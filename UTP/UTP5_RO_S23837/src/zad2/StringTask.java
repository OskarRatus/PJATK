package zad2;
enum TaskState{
    CREATED,
    RUNNING,
    ABORTED,
    READY
}

public class StringTask implements Runnable{
    private String string, output = "";
    private int n;
    private TaskState taskState;

    public StringTask(String str, int n) {
        this.string = str;
        this.n = n;
        this.taskState = TaskState.CREATED;
    }

    @Override
    public void run() {
        this.taskState = TaskState.RUNNING;
        while (!Thread.currentThread().isInterrupted() && !(taskState == TaskState.READY)){
            for (int i = 0; i < n; i++) {
                output += string;
            }

            taskState = TaskState.READY;
        }

    }

    public String getResult(){
        return output;
    }

    public TaskState getState(){
        return taskState;
    }

    public void start(){
        new Thread(this).start();
    }

    public void abort(){
        Thread.currentThread().interrupt();
        taskState = TaskState.ABORTED;
    }

    public boolean isDone(){
        return taskState == TaskState.READY || taskState == TaskState.ABORTED;
    }
}
