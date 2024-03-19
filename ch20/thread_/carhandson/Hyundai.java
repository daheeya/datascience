package ch20.thread_.carhandson;

public class Hyundai { //싱글톤

    public enum Brand{ // inner class
        BMW,
        AUDI,
    }
    private Hyundai(){
        serialNum=1000L;
    };
    private static Hyundai INSTANCE;
    private static Long serialNum;
    public static synchronized Hyundai getInstance(){
        if(INSTANCE==null){
            INSTANCE= new Hyundai();
        }return INSTANCE;
    }

    public Car createCar(Hyundai.Brand brand){
        return switch (brand) {
            case BMW -> new Car(Brand.BMW, serialNum++);
            case AUDI -> new Car(Brand.AUDI, serialNum++);
        };
    }
}
