package collection.birthDay;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BirthDay {
    private String name;
    private Calendar date;

    public BirthDay(String name, Calendar date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        return "BirthDay{" +
                "name='" + name + '\'' +
                ", calendar=" + sdf.format(date.getTime()) +
                '}';
    }
}
