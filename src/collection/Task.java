package collection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Task extends Thread implements Comparable<Task> {
    private String description;
    private Calendar date;

    public Task(String description, Calendar date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Task{" +
                "description='" + description + '\'' +
                ", date=" + sdf.format(date.getTime()) +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.getDate().compareTo(o.getDate());
    }


}
