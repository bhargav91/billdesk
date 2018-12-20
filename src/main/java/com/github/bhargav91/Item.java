package com.github.bhargav91;

/**
 * Created by Bhargav on 12/20/2018.
 */
public class Item {

    private ItemType itemType;
    private String itemName;
    private double price;

    public Item(ItemType itemType, String itemName, double price) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.price = price;
    }

    public Item() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
