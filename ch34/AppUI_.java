package ch34;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppUI_  {
    public static void main(String[] args) {
        //ExecutorService service = Executors.newFixedThreadPool(3);

        Thread task1 = new Thread(new Task("task 1", null));
        Thread task2 = new Thread(new Task("task 2",task1 ));
        Thread task3 = new Thread(new Task("task 3", task2));

//        service.execute(task1);
//        service.execute(task2);
//        service.execute(task3);

        task2.start();
        task1.start();
        task3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Task implements Runnable{

    private String name;
    private Thread joinThread;

    public Task(String name, Thread joinThread){
        this.name=name;
        this.joinThread=joinThread;
    }

    @Override
    public void run() {
        if(joinThread !=null) {
            try {
                joinThread.join();
                System.out.println(name + " wait for " + joinThread.getName() + " to complete.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(name+ " start running.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+" finished...");
    }
}
