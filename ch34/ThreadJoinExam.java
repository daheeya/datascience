package ch34;

public class ThreadJoinExam {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable(),"Thread 1");
        Thread thread2 = new Thread(new MyRunnable(),"Thread 2");

        thread1.start();
        thread2.start();

        // main thread는 not runnable 진입
        thread1.join();  // join 을 호출한 클래스가 not runnable 상태가 된다., main이 끝나고 나서야 Thread1이 runnable 상태가 된다.
        System.out.println("Thread 1 finished!");


    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("finished : "+Thread.currentThread().getName());
    }
}
