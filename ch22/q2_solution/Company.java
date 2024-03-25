package ch22.q2_solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Company {

    private List<Customer> customers;
    private static Long idx=1L;
    // 싱글톤 생성자
    /*


     */
    public Company(){
        customers = new ArrayList<>();
    }

    private Customer findMe(Long idx){
        for ( var customer: customers){
            if(customer.getIdx().equals(idx)) return customer;
        }
        return null;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void createCustomer(String name){
        customers.add(new Customer(idx++, name,Grade.NOMAL));
    }
    private static class ShopCenter{
        private static void buy(int orderPrice, Customer customer){ // 바로 쓸 수 있도록 static
            int totalPrice = orderPrice - (int) (orderPrice*customer.getGrade().getDiscountRate());
            int bonusPoint=(int)(orderPrice*customer.getGrade().getBonusRate());
            customer.setBonusPoint(customer.getBonusPoint()+bonusPoint);

            if(totalPrice>=10000&& customer.getGrade().equals(Grade.NOMAL)){
                var tmpRoyal = new RoyalCustomer(customer.getIdx(), customer.getName());
                customer=tmpRoyal;
                // GC가 알아서 수거해감
            }
        }
    }
}
