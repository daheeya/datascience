package ch13.quiz4;
enum Gender {
    FEMALE,MALE,
}
public class Customer {
    String name;
    int age;
    Gender gender;
    int children;
    public void setCustomer(String name, int age, Gender gender, int children){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.children = children;
    }
    public void printInfo(){
        System.out.println("name : "+name);
        System.out.println("age : "+age);
        System.out.println("gender : "+ gender);
        System.out.println("children : "+ children);
    }
}
