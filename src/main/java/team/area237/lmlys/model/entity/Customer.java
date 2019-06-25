package team.area237.lmlys.model.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends User{
    private String realName;
    private ArrayList<Address> addresses;
    private ArrayList<Order> orders;
    private HashMap<Good, Integer> wishList;

    public HashMap<Good, Integer> getWishList() {
        return wishList;
    }

    public void setWishList(HashMap<Good, Integer> wishList) {
        this.wishList = wishList;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}
