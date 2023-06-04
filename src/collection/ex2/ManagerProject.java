package collection.ex2;

import java.util.List;
import java.util.Vector;

public class ManagerProject extends Thread{
    private List<Project>projects;

    public ManagerProject(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < projects.size(); i++) {
                System.out.println("The projects are: "+projects.get(i).getName() +
                        (projects.get(i).getEndDate().getTimeInMillis()-
                                projects.get(i).getStartDate().getTimeInMillis())/1000/60/60);
            }
            try {
                Thread.sleep(1000 );
            } catch (InterruptedException e) {
            }
        }

    }
}
