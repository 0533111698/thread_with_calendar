package collection.rika;


import java.time.LocalDateTime;
import java.util.Set;

public class ReminderTask implements Runnable {

    private Set<Reminder> reminders;
    private static boolean isRunning = true;

    public ReminderTask(Set<Reminder> reminders) {
        super();
        this.reminders = reminders;
    }

    @Override
    public void run() {
        while (isRunning) {
            checkExperations();
        }
    }

    public void checkExperations() {
        LocalDateTime now = LocalDateTime.now();
        try {
            for (Reminder reminder : reminders) {
                if (reminder.getExpiration().isBefore(now) && !reminder.isPopped()) {
                    if (reminder.isImportant() == true) {
                        System.out.println("Deadline alert" + reminder);
                        reminder.setPopped(true);
                        ImportantReminderTask importantReminderTask = new ImportantReminderTask(reminder);
                        Thread a = new Thread(importantReminderTask);
                        a.start();
                    } else {
                        System.out.println("Deadline alert" + reminder);
                        reminder.setPopped(true);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancelIsRunning() {
        isRunning = false;
    }
}

