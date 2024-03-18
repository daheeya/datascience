package ch18.HandsOn;

import java.util.HashSet;
import java.util.Set;

public class ShopManager {
    Set<Shop> shops;

    public ShopManager(){
        shops=new HashSet<>();
    }
    public void addShop(Shop shop){
        shops.add(shop);
    }
    public Set<Shop> allShops(){
        return shops;
    }
}
