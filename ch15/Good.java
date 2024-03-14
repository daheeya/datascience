package ch15;

public class Good {
    int sum;
    static int index;
    String str;

    // 블럭이 필드처럼 선언됨. (마치 어트리뷰트처럼)
    // instance 블럭
        // new를 했을 때 생성자 함수보다 더 빨리 호출됨
        // 하는 일이 비슷해서 그냥 생성자 함수에다가 . .. 더 많이 씀 .
    {
        index=1;
        for(int i=0;i<50;i++){
            sum+=i;
        }
        System.out.println("instance block");
    }

    // static 블럭- 보통 라이브러리.. 젤먼저 호출되니까 외부 라이브러리가 다 static 블럭에 들어가 있던 이유!!
        // static 이니까 new Good() 했을 때 딱 한번 호출. (딱 한번 메모리에 assign)
    static {
        String data = loadconfigData();
        index=9;
        System.out.println("static block");
        // ...
    }

    private static String loadconfigData(){
        System.out.println("load data ....");
        return "load data ....";
    }

    // default constructor 블럭
    public Good(){
        str="hello";
        System.out.println("default constructor block");
    }
}

class Main3{
    public static void main(String[] args) {
        var good = new Good(); // static는 한번만 . 나머지는 3번 다 호출
        var good1 = new Good();
        var good2 = new Good();
        System.out.println(good.sum);
    }
}
