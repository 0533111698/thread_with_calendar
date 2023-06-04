package collection.ex2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Project {
    private String name;
    private int numOfTasks;
    private Calendar startDate,endDate;


    public Project(String name, Calendar startData, Calendar endDate) {
        this.name = name;
        this.startDate = startData;
        this.endDate = endDate;;
    }
    public Project(){};

    public String getName() {
        return name;
    }

    public int getNumOfTasks() {
        return numOfTasks;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void addTask(int minutes){
        this.numOfTasks++;
        this.endDate.add(Calendar.MINUTE,minutes);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm dd/MM/yyyy");
        return "Project{" +
                "name='" + name + '\'' +
                ", numOfTasks=" + numOfTasks +
                ", startData=" + simpleDateFormat.format(startDate.getTime()) +
                ", endDate=" + simpleDateFormat.format(endDate.getTime())+
                '}';
    }


}
