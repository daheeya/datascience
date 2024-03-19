package ch20.thread_.carhandson;

public class Bmw extends Car{
    private boolean isWindowMode;
    public Bmw(Hyundai.Brand brand, Long serialNum) {
        super(brand, serialNum);
    }
    public void setWindowMode(boolean windowMode) {
        isWindowMode = windowMode;
    }

    public boolean isWindowMode() {
        return isWindowMode;
    }

    @Override
    public String toString() {
        return "Bmw{" +
                super.toString()+ //super의 toString() 도 출력
                "isWindowMode=" + isWindowMode +
                '}';
    }
}
