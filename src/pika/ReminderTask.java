package pika;

import collection.rika.ImportantReminderTask;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class ReminderTask implements Runnable{
   List<Reminder> reminders;

    public ReminderTask(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void run() {
        while (true){
            Calendar now=Calendar.getInstance();
            for (Reminder r:reminders) {
                if (r.getExpiration().before(now) && !r.isPopped()) {
                    if (r.isImportant() == true) {
                        System.out.println("Deadline alert" + r);
                        r.setPopped(true);
                        Thread thread=new Thread(new ReminderImportantTask(r));
                        thread.start();
                    } else {
                        System.out.println("Deadline alert" + r);
                        r.setPopped(true);
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
