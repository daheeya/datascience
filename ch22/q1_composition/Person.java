package ch22.q1_composition;

public class Person {
    protected String name;
    protected int age;
    public Person(String name, int age){
        this.age=age;
        this.name=name;
        System.out.println("Person");
    }
    protected void learn(){ //protected로 바꿔주기. 상속받았을 때만 사용할거라서
        System.out.println("learn()");
    }
    protected void walk(){
        System.out.println("walk()");
    }
    protected void eat(){
        System.out.println("eat()");
    }


}
