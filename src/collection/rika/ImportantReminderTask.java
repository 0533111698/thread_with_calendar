package collection.rika;

import java.util.concurrent.TimeUnit;

public class ImportantReminderTask implements Runnable {

    private Reminder reminder;

    public ImportantReminderTask(Reminder reminder) {
        super();
        this.reminder = reminder;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MINUTES.sleep(1);
            System.out.println("Deadline alert" + reminder);
            TimeUnit.MINUTES.sleep(1);
            System.out.println("Deadline alert" + reminder);
            TimeUnit.MINUTES.sleep(1);
            System.out.println("Deadline alert" + reminder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

