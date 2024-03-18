package ch18.HandsOn;

import java.util.*;

public class Shop {
    private String name;
    private Map<Menu, Integer> menuPrices; //왜 바로 초기화 하지 않을까 // key: Menu, value: Integer
    private Set<Customer> customerOrders;
    // set은 중복이 안되니까 나중에 배울 ArrayList 사용하는게 더 나을 수도. !
    // 그러니까 Order 객체를 만들기
    // private set<Order> customerOrders;
    private Set<Customer> customers;

    private int totalSales;

    public Shop(String name) {
        this.name = name;
        menuPrices=new HashMap<>();
        customerOrders=new HashSet<>();
        customers = new HashSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.name, ((Shop)obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    public void setCustomers(Customer customer){
        customers.add(customer);
    }

    // menu 불러오기


    public Map<Menu, Integer> getMenus() {
        return menuPrices;
    }

    public void setMenuPrices(Menu menu, int menuPrice) {
        menuPrices.put(menu,menuPrice);
    }

    public void makeSale(Customer customer,  int amount){
        if (customers.contains(customer)) {
            customerOrders.add(customer);
            totalSales+=amount;
        }
        else System.out.println("비회원은 주문 불가능");
    }

    public void printOrders(){
        for(var customer: customerOrders){// keyset(): 키값 return
            System.out.println(customer.getName()+" 주문금액: "+getMenus());
        }
    }

    public int getTotalSales() {
        return totalSales;
    }
}
