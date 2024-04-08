package ch33.HandsOn;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Horse implements Runnable{ // Executors 를 쓰기위해 Runnable 객체로 바꿔주기

    private final String name;
    private int distance;

    public Horse(String name){
        this.name=name;
        distance =0;
    }

    @Override
    public void run() {
        /*for(int i=0; i<10; i++){
            distance +=10;
        }
        System.out.println(Thread.currentThread().getName()+" : "+ distance +"m"+" 통과! ");
        */
        while(distance!=100){
            distance+=10;
            System.out.println(name+" : "+ distance +"m");
            try {
                Thread.sleep(new Random().nextInt(1000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name+" 통과! ");
    }
}

class AppUI{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        ExecutorService service = Executors.newFixedThreadPool(num); // pool에 들어있는 애들(runnable 상태) 을 실행

        for(int i =0; i<num; i++){
            // Horse horse = new Horse("horse"+Integer.toString(i+1));
            service.execute(new Horse("horse"+ (i+1)));  // pool에 runnable 객체들이 들어감
        }

        service.shutdown();
    }
}
