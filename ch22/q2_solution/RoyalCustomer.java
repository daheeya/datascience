package ch22.q2_solution;

public class RoyalCustomer extends Customer{
    public RoyalCustomer(Long idx, String name){
        super(idx,name,Grade.ROYAL);
    }
}
