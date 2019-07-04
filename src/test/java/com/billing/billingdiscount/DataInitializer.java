package com.billing.billingdiscount;

import com.billing.billingdiscount.entity.Client;
import com.billing.billingdiscount.entity.ClientType;
import com.billing.billingdiscount.entity.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataInitializer {


    //not apply discount
    public static Item getGroceryItem(int quantity) {
        Item item = new Item(101,"Apple",100.00,true,quantity );
        return item;
    }

    //apply discount
    public static Item getNonGroceryItem(int quantity) {
        Item item =  new Item(102,"Mobile",150.00,false,quantity );
        return item;
    }

    public static Client getAffiliateClient() {
        Client client = new Client(1,"client101",new Date(),ClientType.AFFILIATE);
        return client;
    }

    public static Client getEmployeeClient() {
        Client client = new Client(2,"client102",new Date(),ClientType.EMPLOYEE);
        return client;
    }

    public static Client getLoyaltyClient() {
        Client client = new Client(3,"client103",new Date(1442952000000L),ClientType.CUSTOMER);
        return client;
    }

    public static Client getNonLoyaltyClient() {
        Client client = new Client(4,"client104",new Date(),ClientType.CUSTOMER);
        return client;
    }

    public static List<Item> getMixedItems() {
        List<Item> items = new ArrayList<>();
        items.add(getGroceryItem(4));
        items.add(getNonGroceryItem(4));
        return items;
    }
}
