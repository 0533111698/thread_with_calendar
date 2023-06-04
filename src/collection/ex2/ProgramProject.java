package collection.ex2;

import java.util.*;

public class ProgramProject {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<>();
        ManagerProject mp=new ManagerProject(projects);
        mp.setDaemon(true);
        mp.start();
        int choose;
        do {
            System.out.println("1>\tCreate new Project\n" +
                    "2>\tAdd task to Project\n" +
                    "3>\tPrint all projects\n" +
                    "4>\tExit\n");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    projects.add(createProject());
                    break;
                case 2:
                    System.out.println("please insert the length of task");
                    int minutes = scanner.nextInt();
                    System.out.println("please insert index");
                    int index = scanner.nextInt();
                    try {
                        projects.get(index - 1).addTask(minutes);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Invalid index please try again");
                    }


                    break;
                case 3:
                    System.out.println(projects);
                    break;
                case 4:
                    System.out.println("bye bye");
                    break;
                case 5:
                    System.out.println("Invalid choice");
            }

        }while (choose != 4);


    }

    private static Project createProject() {
        System.out.println("please insert a name");
        String name = scanner.next();
        Calendar startDate=createStartEndDate(1);
        Calendar endDate=createStartEndDate(2);

        return new Project(name,startDate,endDate);
    }

    private static Calendar createStartEndDate(int i) {
        Calendar cal=Calendar.getInstance();
        if (i==1) {
            System.out.println("Please insert start date for the project");
        }else {
            System.out.println("Please insert end date for the project");
        }
            System.out.println("the yer is:");
            int year=scanner.nextInt();
            System.out.println("the month is: ");
            int month=scanner.nextInt()-1;
            System.out.println("the day is: ");
            int day=scanner.nextInt();
            System.out.println("the hour is: ");
            int hour=scanner.nextInt();
            System.out.println("the minutes are: ");
            int minutes=scanner.nextInt();
            System.out.println("the seconds are: ");
            int seconds=scanner.nextInt();
            cal.set(year,month,day,hour,minutes,seconds);

        return cal;


    }


}
