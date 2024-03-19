package ch20.thread_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    private static Singleton INSTANCE;
    private Singleton(){}; // new Singleton 을 할 수 없도록 오버로딩:? 오버라이딩?
    /*
public static Singleton getINSTANCE(){
    if(INSTANCE==null){
        INSTANCE=new Singleton();
    }
    return INSTANCE;
}
*/
    // synchronized 키워드를 통해 동시 접근을 예방할 수 있다.
    public static synchronized Singleton getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE=new Singleton();
        }
        return INSTANCE;
    }
}
class Main_{ // Main_ 프로세스
    public static void main(String[] args) { // main 스레드
        // Singleton singleton=new Singleton(); // 안됨 왜냐하면 private이기 때문에 타 객체에서 못 쓴다.
        // 쓰려면
        //Singleton singleton1=Singleton.getINSTANCE(); // 이건 우리가 하나만 객체를 생성할 때
        Singleton[] singletons=new Singleton[10]; // 여러개의 싱글톤 객체를 생성하기 위해

        //Thread Pool 생성
        ExecutorService service = Executors.newCachedThreadPool();// 쓰레드를 저장할 수 있는 쓰레드 pool 생성<-여기다가 우리가 만든 서비스를 집어넣을거임
        // 우리가 별개의 여러개의 쓰레드를 만들 때 ExecutorService를 받아오고 여기에 우리가 서비스를 넣어주면 새로운 스레드로 다 만들어준다.

        // service.submit(new Runnable 엔터 치면 자동완성됨.
        for (int i =0; i<10;i++){
            final int num = i; // 내부의 인덱스 변수는 꼭 final로 변하지 않도록 해줘야함.
            service.submit(new Runnable() { // 함수가 run() 하나뿐이라서 그냥 이렇게 바로 사용가능
                @Override // Runnable메소드는 추상화객체라서 꼭 오버라이드가 되어야한다.
                public void run() {
                    singletons[num]=Singleton.getINSTANCE();
                }
            }); // pool에 넣어줌
            // runable 객체는 Thread.start() 하게되면 runable 상태로 집입하게 됨 (나중에 배우긴 할거래요) 그러면 runable status로 변하게 되고 , CPU가 실행 가능한 상태(CPU의 스케줄링 방법에 따라 지 알아서 해줌 라운드로빈이니뭐니(정처기에 나오는 내용이라 반가워서 ㅎ))일 때 runable 상태의 스레드를 하나꺼내서 run(실행) 시킴 <- 그러니까 우리는 runable 상태로 만들어주는 일만 해줌
            // 각각의 쓰레드로 pool에 넣어줌, CPU에 runnable 상태로 넣어줌. 이것만 이해해도 돼요
            // 지금 싱글톤에 getIstance가 여러개일 때 어떻게 실행되나 보려고 하는거임.
        }
        System.out.println("Main end_----------------");
        // thread pool이 더이상 필요없다면 닫아줘라.
        service.shutdown(); // threadpool 삭제 .반드시 shutdown 해주기.

        // singleton 의 주소찍어보기
        for (var s:singletons){
            System.out.println(s);
        }
        // 싱글톤 패턴에 어긋나는 걸 확인 가능: 여러개의 Singleton 이 생성됨
        // 여러개의 스레드를 만들어서 실행해보니까 싱글톤이 제대로 작동하지 않네~ 만 알면 됨.

    }
}
