package ch13.quiz4;

import javax.swing.*;

public class Cafe {
    String name;
    Customer[] customers = new Customer[5];
    Menu[] menus = new Menu[MAX_MENU];
    int menuIdx =0;
    int customerIdx =0;
    static int MAX_MENU=3;

    public void setName(String name) {
        this.name = name;
    }
    public void addCustomer(String name, int age, Gender gender, int children){
        if(customerIdx<customers.length){
        Customer customer =new Customer();
        customer.setCustomer(name,age, gender, children);
        customers[customerIdx]=customer;
        customerIdx++;
        }
    }

    public void checkOrder (Order order){ // Order가 주문한 메뉴와 Cafe에 등록된 메뉴가 같은지 확인
        if(order.getMenus()==menus){}
    }


    public void addMenu(Menu menu){ // Cafe에 메뉴 등록
        if(menuIdx<MAX_MENU) {
            menus[menuIdx] = menu;
            menuIdx++;
        }
    }
    // 주문 처리 완료되면 주문 리스트에서 삭제..?
    // 주문이 가능한지 여부만 체크..?


}
