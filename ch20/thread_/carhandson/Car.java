package ch20.thread_.carhandson;

public class Car {
    private Long serialNum;

    private Hyundai.Brand brand;
    // private static Long serialNum=1000L; // menufactor(Hyundai)에서 만들어야함.
    public Car(Hyundai.Brand brand, Long serialNum){ // 생성자 함수이기 때문에 여기서 조건 넣지말고 초기화만 하기.
        this.brand=brand;
        this.serialNum=serialNum;
    }

    public Long getSerialNum() {
        return serialNum;
    }

    public Hyundai.Brand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNum=" + serialNum +
                ", brand=" + brand +
                '}';
    }
}
