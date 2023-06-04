package pika;

public class ReminderImportantTask implements Runnable {
    private Reminder reminder;

    public ReminderImportantTask(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("trrrrr"+reminder);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("trrrrr"+reminder);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("trrrrr"+reminder);
    }
}
