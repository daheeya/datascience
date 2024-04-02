package ch28;

import java.util.ArrayList;
import java.util.List;

public class FruitBox <T>{ // 타입 미정 -> 런타임 때 타입이 정해진다.

    List<T> fruits = new ArrayList<>();

    public void add(T fruit){
        fruits.add(fruit);
    }
}

class Fruit{}

class Apple extends Fruit{
    private int color = 1;
}
class Main_{
    public static void main(String[] args) {
        var intBox = new FruitBox<Integer>(); // Generic Type은 기본형 타입은 안되고 무조건 객체여야 한다.
        intBox.add(12);

        var appleBox = new FruitBox<Apple>();
        // 다형성도 적용한다.
        var fruitBox = new FruitBox<Fruit>();
        fruitBox.add(new Apple());
        List<Apple> apples = new ArrayList<>();
    }
}