package com.github.bhargav91;

import java.util.Date;

/**
 * Created by Bhargav on 12/20/2018.
 */
public class BillingCalculatorImpl implements BillingCalculator {
    public double calculateBillAmount(Bill bill) {
        double amountPayable = 0;

        for(Item item : bill.getItems()){
            double percentageDiscount = calculatePercentageDiscount(bill.getUser(), item);
            amountPayable += item.getPrice() - percentageDiscount;
        }
        return amountPayable - getPriceDiscount(amountPayable);
    }


    private double calculatePercentageDiscount(User user, Item item) {
        double discount = 0;
        if(ItemType.OTHERS.equals(item.getItemType())){
            return discount;
        }
        UserType userType = user.getUserType();
        switch (userType){
            case EMPLOYEE:
                discount = item.getPrice() * 0.3;
                break;
            case AFFILIATE:
                discount = item.getPrice() * 0.1;
                break;
            case CUSTOMER:
                if(isCustomerApplicableForDiscount(user)){
                    discount = item.getPrice() * 0.05;
                }
                break;
        }
        return discount;
    }

    private double getPriceDiscount(double amount) {
        return ((int) (amount / 100)) * 5;
    }

    private boolean isCustomerApplicableForDiscount(User customer){
        Date registrationDate = customer.getDateOfRegistration();
        Date today = new Date();

        int tenure = (int) ((today.getTime() - registrationDate.getTime()) / (1000 * 60 * 60 * 24)) / 365;

        if(tenure > 2){
            return true;
        }
        return false;
    }

}
