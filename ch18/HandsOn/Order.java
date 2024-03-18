package ch18.HandsOn;

public class Order {
    private Customer customer;
    private int amount;

    public Order(Customer customer, int amount){ // 안쓰나..? ㅠ
        this.customer=customer;
        this.amount=amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
