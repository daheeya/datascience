package ch26.HandsOn;

abstract public class Pet {
    protected int age;

    protected Pet(int age){
        this.age=age;
    }

    abstract public void walk();
    protected void eat(){
        System.out.println("eat()");
    }
    protected void jump(){
        System.out.println("jump()");
    }
}
class Dog extends FlyAdaper{

    private String nickname;

    protected Dog(int age, String nickname){
        super(age);
        this.nickname=nickname;
    }

    @Override
    public void walk(){
        System.out.println("Dog walk()");
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
class Cat extends Pet{
    public Cat(int age){
        super(age);
    }

    @Override
    public void walk(){
        System.out.println("Cat walk()");
    }
}

class Snake extends FlyAdaper{
    public Snake(int age){
        super(age);

    }

    @Override
    public void walk() {
        System.out.println("snake walk()");
    }
}
abstract class FlyAdaper extends Pet{
    protected FlyAdaper(int age){
        super(age);
    }

    protected void fly(){
        System.out.println("fly()");
    }
}

class AppUI{
    public static void main(String[] args) {
        var dog= new Dog(2, "누렁이");
        var cat = new Cat(3);
        var snake = new Snake(3);
        var UI = new AppUI();

        UI.morningRoutine(dog);
        UI.morningRoutine(cat);
        UI.morningRoutine(snake);
        dog.fly();
        snake.fly();
    }
    public void morningRoutine(Pet pet){
        if(pet instanceof Dog) System.out.println(((Dog) pet).getNickname());
        pet.walk();
        pet.eat();
        pet.jump();
    }
}
