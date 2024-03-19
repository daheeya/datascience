package ch20.thread_.carhandson;


public class AppUI {
    public static void main(String[] args) {
        Car bmw = Hyundai.getInstance().createCar(Hyundai.Brand.BMW);
        new AppUI().carSetFunction(bmw);
        Car audi = Hyundai.getInstance().createCar(Hyundai.Brand.AUDI);
        new AppUI().carSetFunction(audi);

        System.out.println(bmw);
        System.out.println(audi);
    }

    public void carSetFunction(Car car){
        if(car instanceof Bmw)((Bmw)car).setWindowMode(true); //Bmw 로 명시적 형변환을 해야 setWindowMode함수가 보임
        else if (car instanceof Audi) ((Audi)car).setBoosterMode(true);
    }





}
