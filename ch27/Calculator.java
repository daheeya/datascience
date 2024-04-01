package ch27;

interface Operate{
    int operate(int a, int b);
}
public class Calculator {
    private int a;
    private int b;

    public Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int calculate(Operate operate){
        return operate.operate(a,b);
    }
}
class AppUI_{
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        Calculator plus = new Calculator(num1 ,num2);
        int result = plus.calculate(new Operate() { // 런타임 시 오버라이드 가능해짐.
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        });
        System.out.println(result);

        Calculator minus = new Calculator(num1, num2);
        int result2 = minus.calculate(new Operate() {
            @Override
            public int operate(int a, int b) {
                return b-a;
            }
        });
        System.out.println(result2);

        // 익멱 클래스를 활용할 수 있으면 코드 전체가 바뀐다.
        // 어떨 땐 곱하기고 어떨 땐 더하긴데 ? 하면 이렇게 익명클래스 사용 가능.
        // 실행타임 때 결정될 수 있기 때문에 메모리가 가벼워짐
        // 컴파일 때 결정된다면 메모리 잡아먹음.
        // new 는 동적메모리로 런타임 때 생성됨. 그러니까

        // 클래스의 이름이 없으니까 익명클래스, 내 맘대로 메소드 구현 가능
        // 한번 쓰고 말건데 컴파일 때 만들어 놓으면 비생산적이니까!
    }
}
