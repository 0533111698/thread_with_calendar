package collection;

import java.util.Calendar;
import java.util.List;

public class TaskManager implements Runnable{
    List<Task>tasks;

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void run() {
        while (true){
            Calendar now=Calendar.getInstance();
            for (int i = 0; i <tasks.size(); i++) {
                if (tasks.get(i).getDate().before(now)){
                    System.out.println("The task"+"\'"+tasks.get(i).getDescription()+"\'"+" is over");
                }

            }
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {}
        }

    }

}
