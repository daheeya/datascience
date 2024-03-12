package ch13.quiz3;

import java.util.Objects;

public class Person {
    String name;
    int money;

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void printInfo(){
        System.out.println("이름: "+name+" 가진 돈: "+money);
    }
}
