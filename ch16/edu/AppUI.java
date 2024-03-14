package ch16.edu;

public class AppUI {
    public static void main(String[] args) {
        var korean = new Subject(Course.KOREAN,Constants_C.KOREAN_CODE,30);
        var math = new Subject(Course.MATH,Constants_C.MATH_CODE,10);
        var kavin=new Student("kavin");
        kavin.addSubject(korean);
        kavin.addSubject(math);
        System.out.println(kavin.totalScore());

        System.out.println(kavin); // arrays를 넣었기 때문에 . . ? Student에서 toString 오버로딩
        // 걍 클래스를 만들면 습관적으로 toString 만들어라 ..!

    }
}