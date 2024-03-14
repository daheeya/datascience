package ch15;

public class Car {
    String modelName; // 변수 선언 동시에 초기화 하기 보다 생성자에서 초기화하는 것이 더욱 더 사용자 관점
    String color;
    int maxSpeed;
    public Car(){
        // System.out.println("Car: Hello! "); //<- this 생성자 위에서 불가능
        // int i =10; // <- this 생성자 앞에서 불가능.
        //modelName="KIA"; // 생성자에서 초기화 가능.
        //color="BLUE";

        this("KIA","BLUE"); // this 생성자 : private 해놓은 오버로딩 함수를 호출해서 파라미터로 들어감 -> 더욱 가독성이 좋다.
        //this 생성자: 무조건 첫번째로 들어와야함
        // 가독성과 유지보수를 위해서 좋다.
        // 그냥 함수에서는 안되고 무조건 생성자 함수에서만 호출 가능
    }
    private Car(String modeName, String color){ //private 시 다른 클래스에서 볼 수 없음
        this.modelName=modeName;
        this.color=color;
        maxSpeed=90;
    }
    public static void setModel(String modelName){
        // this.modelName=modelName; -> this. 사용 불가능
    }
}
class Main2{
    public static void main(String[] args) {
        var car = new Car(); // car 라는 객체가 힙메모리에 생성되고 Car()가 자동으로 호출
        System.out.println("main~");

        // 생성자 오버로딩
        // 기본생성자는 더 이상 컴파일러가 제공하지 않는다.
        //var superCar = new Car("AUDI","RED"); // 오버로딩을 통해 생성할 때 파라미터를 넣을 수 있게 됨
    }
}
