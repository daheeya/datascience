package ch13.quiz3;

public class AppUI {
    public static void main(String[] args) {
        Person james = new Person();
        Person tomas = new Person();
        Vehicle bus = new Vehicle();
        Vehicle subway = new Vehicle();
        bus.setName("bus");
        bus.setPrice(1000);

        subway.setName("subway");
        subway.setPrice(1500);

        james.setName("james");
        james.setMoney(5000);


        tomas.setName("tomas");
        tomas.setMoney(4000);


        bus.takePassenger(james);
        bus.printInfo();
        james.printInfo();
        bus.takePassenger(james);
        bus.takePassenger(james);
        james.printInfo();
        bus.printInfo();

    }


}
