package collection.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock implements Runnable {


    @Override
    public void run() {
        while (true){
            Calendar calendar=Calendar.getInstance();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            System.out.println(simpleDateFormat.format(calendar.getTime()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
