package collection.birthDay;

import java.util.Calendar;
import java.util.List;

public class BirthDayThread extends Thread{
    private List<BirthDay>birthDays;

    public BirthDayThread(List<BirthDay> birthDays) {
        this.birthDays = birthDays;
    }

    @Override
    public String toString() {
        return "BirthDayThread{" +
                "birthDays=" + birthDays +
                '}';
    }

    @Override
    public void run() {
       while (true){
           Calendar today=Calendar.getInstance();
           for (BirthDay b:birthDays) {
               if (b.getDate().get(Calendar.MONTH)==today.get(Calendar.MONTH)
               &&b.getDate().get(Calendar.DATE)==today.get(Calendar.DATE))
                   System.out.println("Happy birthday to: "+b.getName()+"!!!");
           }
           try {
               Thread.sleep(1000*60*60*24);
           } catch (InterruptedException e) {
           }
       }
    }
}
