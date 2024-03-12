package ch13.quiz3;

import java.util.Objects;

public class Person {
    String name;
    int money;

    Vehicle vehicle;

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void takeVehicle(Vehicle vehicle){
        if(money>=vehicle.getPrice()){
            money-= vehicle.getPrice();

            if (this.vehicle!=null) {
                this.vehicle.takeOffVehicle();
            }
            this.vehicle = vehicle;
            vehicle.takeVehicle();
        }
    }
    public void printInfo(){
        System.out.println("이름: "+name+" 가진 돈: "+money);
    }
}
