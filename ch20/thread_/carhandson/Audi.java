package ch20.thread_.carhandson;

public class Audi extends Car {
    private boolean isBoosterMode;
    public Audi(Hyundai.Brand brand, Long serialNum){ // 상속받았기 때문에
        super(brand,serialNum); // 부모 클래스 꼭 오버로딩 해주기
    }
    public void setBoosterMode(boolean boosterMode) {
        isBoosterMode = boosterMode ;
    }
    public boolean isBoosterMode() {
        return isBoosterMode;
    }

    @Override
    public String toString() {
        return "Audi{" +
                super.toString()+
                "isBoosterMode=" + isBoosterMode +
                '}';
    }
}
