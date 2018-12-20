package com.github.bhargav91;

import java.util.List;

/**
 * Created by Bhargav on 12/20/2018.
 */
public class Bill {
    private User user;
    private List<Item> items;
    private double billAmount;

    public Bill(User user, List<Item> items, double billAmount) {
        this.user = user;
        this.items = items;
        this.billAmount = billAmount;
    }

    public Bill() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
