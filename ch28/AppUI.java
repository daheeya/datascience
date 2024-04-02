package ch28;

@FunctionalInterface // 함수형 인터페이스 : 추상화 메소드가 하나만 있는 인터페이스
interface IAdd<T>{
    T add(T x, T y);
}
public class AppUI {
    public static void main(String[] args) {
        IAdd<Integer> o = (x, y) -> x+y; // 인터페이스가 하나뿐이라서 인터페이스를 그냥 객체로 소환하고 굳이 구현할 필요가 없다.
        System.out.println(o.add(3,4));
    }

}
