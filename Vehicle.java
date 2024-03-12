package ch13.quiz3;

public class Vehicle {
    String name;
    int price;
    int passengerCnt;
    int earnMoney;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void takeVehicle(){
        this.passengerCnt++;
        this.earnMoney+=this.price;
    }
    public void takeOffVehicle(){
        this.passengerCnt--;
    }


    public void printInfo(){
        System.out.println(this.name+"탑승객: "+this.passengerCnt+"명, 지불한 돈: "+earnMoney);
    }
}
