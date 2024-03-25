package ch22;

public class Dancer extends Person{
    private String groupName;
    public Dancer(String name, int age, String groupName){
        super(name,age);
        this.groupName=groupName;
        System.out.println(super.name+", "+super.age);
        System.out.println("Dancer, groupName: "+ groupName);
    }
    public void dancing(){
        System.out.println("dancing!");
    }
}
