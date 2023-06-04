package collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Task> myList=new ArrayList<>();
        Calendar cal1=Calendar.getInstance();
        cal1.set(cal1.MINUTE,10);
        myList.add(new Task("Go Sleep",cal1));
        Calendar cal2=Calendar.getInstance();
        cal2.set(cal2.MINUTE,9);
        myList.add(new Task("Do Bath",cal2));


        Thread thread=new Thread(new TaskManager(myList));
        thread.start();
        while (true){
        Collections.sort(myList);
        System.out.println(myList);
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
            }
        }


    }
}
