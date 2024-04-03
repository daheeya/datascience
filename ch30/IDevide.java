package ch30;

public interface IDevide {
    int devide(int x, int y);
}
class AppUI_{
    public static void main(String[] args) {

        // 람다식을 변수로
        IDevide iDevide = (x,y)->(x/y);
        iDevide.devide(8,2);
        System.out.println(iDevide);

        IDevide makeF = makeFunc();
        makeF.devide(6,3);

        System.out.println(resultMethod(((x, y) -> x/y)));
    }

    // 람다식 매개변수 할당
    public static int resultMethod(IDevide lambda){
        return lambda.devide(10,2);
    }

    // 람다식을 반환값으로 할당
    public static IDevide makeFunc(){
        return (x, y) -> x/y; // IDevide를 구현한 구현체 (IDevide에서 오버라이딩하는)
    }
}
