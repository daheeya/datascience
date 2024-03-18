package ch18.HandsOn;

public class AppUI {
    public static void main(String[] args) {
        //center
        var center = new ShopManager();

        // shop 등록
        var shop = new Shop("starbucks");
        center.addShop(shop);

        // shop menu 등록
        shop.setMenuPrices(Menu.AMERICANO,2000);
        shop.setMenuPrices(Menu.CAFELATTE,3500);

        //customer
        var customer = new Customer("email@daegu.ac.kr","kavin");

        // 회원가입
        shop.setCustomers(customer);

        // login 후에 등록된 shop의 리스트를 보여준다.
        var shops = center.allShops();
        Shop findShop = null;
        for(var s:shops){
            if(s.equals(shop)){
                findShop=s;
                break;
            }
        }

        // 찾은 shop의 menu 리스트를 보여준다.
        var menus = findShop.getMenus();

        findShop.printOrders();
        findShop.makeSale(customer, menus.get(Menu.AMERICANO));
        findShop.makeSale(customer, menus.get(Menu.CAFELATTE));
        System.out.println(findShop.getTotalSales());
        findShop.printOrders();
    }
}
