package ch20.thread_.bankhandson;

public class Account {
    private String name;
    private String accountNum;
    private int balance;
    public Account(Customer customer, String accountNum){
        this.accountNum=accountNum;
        this.name=customer.getName();
    }
}
