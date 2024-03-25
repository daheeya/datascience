package ch22.q2;

public class AppUI {
    public static void main(String[] args) {
        var customerService = new CustomerService();
        var dahee = customerService.createCustomer("1234","dahee");
        dahee.purchase(15000);

    }
}
