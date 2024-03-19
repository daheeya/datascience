package ch20.thread_.bankhandson;

public class Customer {
    private String name;
    private String personalNum;
    public Customer(String name, String personalNum){
        this.name=name;
        this.personalNum=personalNum;
    }

    public String getName() {
        return name;
    }
    public String getPersonalNum() {
        return personalNum;
    }

    // equals, hashcode 필요할까.



}
