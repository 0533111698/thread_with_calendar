package collection.secondTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task implements Comparable<Task>{
    private String description;
    private Calendar targetDate;

    public Task(String description, Calendar targetDate) {
        this.description = description;
        this.targetDate = targetDate;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getTargetDate() {
        return targetDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        return "{" +
                "description is " + description + '\'' +
                ", targetDate is" + sdf.format(targetDate.getTime()) +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.targetDate.compareTo(o.targetDate);
    }
}
