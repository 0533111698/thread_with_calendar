package collection.secondTask;

import java.util.*;

public class Program {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        List<Task>tasks = new ArrayList<>();
        TaskManager taskManager=new TaskManager(tasks);
        int choice;
        do {
            System.out.println("1> add task to the manager project\n2> print the tasks\n3>exit\nenter yor choice");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    tasks.add(createTask());
                    break;
                case 2:
                    System.out.println(tasks);
                    break;
                case 3:
                    System.out.println("have a nice day, good bye");
                    break;
                default:
                    System.out.println("invalid choice! try again...");
            }
        }while (choice!=3);
        Collections.sort(tasks);
        while (true){
            System.out.println(tasks);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static Task createTask() {
        System.out.println("Please enter description of task");
        String description=scanner.next();
        Calendar targetDate=createTargetDate();
        return new Task(description,targetDate);
    }

    private static Calendar createTargetDate() {
        System.out.println("Please enter target date\nThe year is:");
        int year=scanner.nextInt();
        System.out.println("The month is:");
        int month=scanner.nextInt();
        System.out.println("The day is:");
        int day=scanner.nextInt();
        System.out.println("The hour is:");
        int hour=scanner.nextInt();
        System.out.println("The minutes are:");
        int minutes=scanner.nextInt();
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month-1,day,hour,minutes,0);
        return calendar;
    }
}
