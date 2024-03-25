package ch22;

public class Programmer extends Person {
    private String company;
    public Programmer(String name, int age, String company){
        super(name,age);
        this.company=company;
        System.out.println("Programmer, GroupName: "+ company);
    }
    public void coding(){
        eat(); // 부모의 메소드 구현 가능
        System.out.println("coding");
    }
}
