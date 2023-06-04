package pika;

import java.util.*;

public class Program {
    static Scanner scanner=new Scanner(System.in);
    List<Reminder> reminders;
    public static void main(String[] args) {
        List<Reminder> reminders=new ArrayList<>();
        Thread thread=new Thread(new ReminderTask(reminders));
        thread.start();
        Collections.sort(reminders);
        int choice;
        do {
            System.out.println("1>add reminder\n2> print reminders\n3>exit\nenter your choice");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    reminders.add(createReminder());
                    break;
                case 2:
                    System.out.println(reminders);
                    break;
                case 3:
                    System.out.println("have a nice day! good bye");
                    break;
                default:
                    System.out.println("Invalid choice, try again...");

            }
        }while (choice!=3);


    }

    private static Reminder createReminder() {
        Calendar expiration=createExpiration();
        String text=createText();
        boolean important=createIsImportant();
        return new Reminder(expiration,text,important);
    }

    private static boolean createIsImportant() {
        System.out.println("If the reminder is important enter 'yes' if it's not important enter 'no'");
        String special=scanner.next();
        boolean important = false;
        if (special.equals("yes"))
            important=true;
        else if (special.equals("no") ) {
            important=false;
        }else
            System.out.println("Invalid choice");
        return important;
    }

    private static String createText() {
        System.out.println("enter reminder description:");
        String text=scanner.next();
        return text;
    }

    private static Calendar createExpiration() {
        System.out.println("Please insert expiration\n The year is :");
        int year=scanner.nextInt();
        System.out.println("The month is ");
        int month=scanner.nextInt();
        System.out.println("The day is ");
        int day=scanner.nextInt();
        System.out.println("The hour is ");
        int hour=scanner.nextInt();
        System.out.println("The minutes are ");
        int minutes=scanner.nextInt();
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month-1,day,hour,minutes,0);
        System.out.println(calendar.getTime());
        while (calendar.before(Calendar.getInstance())){
            System.out.println("The date already over");
            System.out.println("Please insert expiration\n The year is :");
            year=scanner.nextInt();
            System.out.println("The month is ");
            month=scanner.nextInt();
            System.out.println("The day is ");
            day=scanner.nextInt();
            System.out.println("The hour is ");
            hour=scanner.nextInt();
            System.out.println("The minutes are ");
            minutes=scanner.nextInt();
            calendar=Calendar.getInstance();
            calendar.set(year,month-1,day,hour,minutes,0);

        }
        return calendar;
    }
}
