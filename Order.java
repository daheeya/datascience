package ch13.quiz4;

import java.util.Arrays;

public class Order {
    Customer customer;
    Menu[] menus = new Menu[MAX_MENU];
    int i =0;
    static int MAX_MENU=3;

    public void printInfo(){
        System.out.println(customer+" : "+ Arrays.toString(menus));
        System.out.println("date : ");
    }
    public void addMenu(Customer customer, Menu menu) {
        this.customer=customer;
        if (i < MAX_MENU) {
            menus[i] = menu;
            i++;
        }
    }

    public Menu[] getMenus() {
        return menus;
    }
}
