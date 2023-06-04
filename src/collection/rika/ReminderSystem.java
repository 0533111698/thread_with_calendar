package collection.rika;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ReminderSystem {

    private Set<Reminder> reminders;
    private ReminderTask task;
    private boolean systemOn = true;

    private static final Scanner scanner = new Scanner(System.in);

    public ReminderSystem() {
        this.reminders = new HashSet<>();
        this.task = new ReminderTask(reminders);
        Thread r = new Thread(task);
        r.setDaemon(true);
        r.start();
    }

    public boolean addReminder(Reminder reminder) {
        return reminders.add(reminder);
    }

    public List<Reminder> getReminders() {
        List<Reminder> reminderList = new ArrayList<>(reminders);
        Collections.sort(reminderList);
        return reminderList;
    }

    public void reminderMunu() {
        System.out.println();
        System.out.println("Add Reminder..............1");
        System.out.println("Show Reminders.............2");
        System.out.println("exit................3");
        System.out.println("Enter your choice:");
    }

    public void startSystem() {

        while (systemOn) {

            // try {
            reminderMunu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    addReminder(getReminderFromUser());
                    System.out.println("you added successfully");
                    break;
                case "2":
                    System.out.println(getReminders());
                    break;
                case "3":
                    endSystem();
                    return;
                default:
                    System.out.println("error");
                    break;
            }
            // } catch (Exception e) {
            // System.out.println("error " + e.getMessage());
            // }
        }
        scanner.close();
    }

    public Reminder getReminderFromUser() {
        System.out.print("enter reminder description: ");
        String text = scanner.nextLine();
        System.out.println("enter time hh:mm:ss ");
        String time = scanner.nextLine();
        LocalDateTime expiration = LocalDateTime.of(LocalDate.now(), LocalTime.parse(time));
        LocalDateTime now = LocalDateTime.now();
        while (expiration.isBefore(now)) {
            System.out.println("Date already passed");
            System.out.println("enter time hh:mm:ss ");
            time = scanner.nextLine();
            expiration = LocalDateTime.of(LocalDate.now(), LocalTime.parse(time));
        }

        for (Reminder reminder : reminders) {
            if ((reminder.getText().equals(text)) && (reminder.getExpiration().equals(expiration))) {
                System.out.println("The same task and the same date already exist there");
                System.out.print("enter reminder description: ");
                text = scanner.nextLine();
                System.out.println("enter time hh:mm:ss ");
                time = scanner.nextLine();
                expiration = LocalDateTime.of(LocalDate.now(), LocalTime.parse(time));

            }
        }

        Reminder reminder = new Reminder(expiration, text);
        return reminder;
    }

    public void endSystem() {
        System.out.println("Thank you and goodbye");
        scanner.close();
        systemOn = false;
        ReminderTask.cancelIsRunning();
    }

}
