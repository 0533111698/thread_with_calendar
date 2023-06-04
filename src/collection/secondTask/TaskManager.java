package collection.secondTask;

import java.util.Calendar;
import java.util.List;

public class TaskManager extends Thread {
    private List<Task>tasks;

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true){
            Calendar now=Calendar.getInstance();
            for (Task t:tasks) {
                if (t.getTargetDate().before(now)) {
                    System.out.println("Task"+t.getDescription()+"is over!");
                }

            }
            try {
                Thread.sleep(1000+60);
            } catch (InterruptedException e) {
            }
        }
    }
}
