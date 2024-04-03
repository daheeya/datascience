package ch30;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }); // Runnable()의 run() 결국 한번 쓰고 말거라서 익명클래스나 람다식을 쓰는게 효율적이다.(Runnable도 함수형잉ㄴ터페이스
        Thread thread1 = new Thread(()->{ // Runnable 객체
            int i = 9;
            System.out.println("uuu");
        });
        thread1.start();
    }
}
