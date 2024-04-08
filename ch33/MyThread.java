package ch33;

// case3 : 익명 객체 사용

class AppUI{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread()+"start");


        //람다식 사용
        new Thread(()->{ // 파라미터가 없기 때문에 그냥 () ->
            System.out.println(Thread.currentThread()+"start");
            for(int i =0; i<10; i++){
                System.out.print(i+" ");
            }
            System.out.println();
        }).start();



        System.out.println(Thread.currentThread()+"end");
    }
}