package collection.clock;

public class Program {
    public static void main(String[] args) {
        Thread thread=new Thread(new Clock());
        thread.start();
        while (true){
        System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }



    }
}
