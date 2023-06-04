package collection.birthDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ProgramBirthday {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        List<BirthDay>birthDays=new ArrayList<>();
        BirthDayThread bt=new BirthDayThread(birthDays);
        bt.start();
        int choice ;
        do {
            System.out.println("1> add birthday:\n2>print birthday\n>3exit\nplease choose");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    birthDays.add(createBirthday()) ;
                    break;
                case 2:
                    System.out.println(birthDays);
                    break;
                case 3:
                    System.out.println("good bye");
                    break;
                default:
                    System.out.println("please try again");
            }

        }while (choice!=3);

    }



    private static BirthDay createBirthday() {
        System.out.println("please insert a name");
        String name=scanner.next();
        Calendar date=createDate();
        BirthDay birthDay=new BirthDay(name,date);
        return birthDay;
    }

    private static Calendar createDate() {
        Calendar calendar=Calendar.getInstance();
        System.out.println("please insert a date\n the day is: ");
        int day=scanner.nextInt();
        System.out.println("The month is: ");
        int month=scanner.nextInt()-1;
        System.out.println("The year is: ");
        int year=scanner.nextInt();
        calendar.set(year,month,day);
        return calendar;
    }


}
