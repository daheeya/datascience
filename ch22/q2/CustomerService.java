package ch22.q2;

public class CustomerService{
    private Customer customer;

    public CustomerService(){

    }
    public Customer createCustomer(String id, String name){
        customer=new Nomal(id,name);
        return customer;
    }

    private void gradeUp(){
        if(customer.getTotalPayment()>=10000 && customer.getGrade().equals(Grade.NOMAL)) {
            var royal=new Royal(customer.id,customer.name);
            customer=royal;
        }
    }


}
