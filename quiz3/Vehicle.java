package ch13.quiz3;

public class Vehicle {
    String name;
    int price;
    int passengerCnt;
    int earnMoney;
    int[] passenger = new int[2];
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

    public void takePassenger(Person person) {
        if (person.getMoney() > getPrice()) {
            person.setMoney(person.getMoney() - getPrice());
            earnMoney += price;
        }
        this.passengerCnt++;
        // 같은 사람이 탔을 때 카운트 다운.

    }
    public void takeOffVehicle(){
        this.passengerCnt--;
    }


    public void printInfo(){
        System.out.println(this.name+"탑승객: "+this.passengerCnt+"명, 지불한 돈: "+earnMoney);
    }
}
