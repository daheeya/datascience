package ch27;

interface IAnimal{
    String move(); // public abstract
    String run();

}



public class Animal {


}

class AppUI{
    public static void main(String[] args) {
        IAnimal dog = new IAnimal() {
            @Override
            public String move() {
                return "개가 짓습니다.";
            }

            @Override
            public String run() {
                return "개가 달립니다.";
            }
        };

        System.out.println(dog.move());
        System.out.println(dog.run());
    }
}