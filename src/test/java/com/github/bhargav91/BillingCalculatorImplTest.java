package com.github.bhargav91;

import org.junit.Test;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Bhargav on 12/20/2018.
 */
public class BillingCalculatorImplTest {
    private static int userId;

    private BillingCalculator billingCalculator;
    private List<Item> items = new ArrayList<Item>();
    private User user;
    private Bill bill;

    private Item pencil = new Item(ItemType.OTHERS, "Pencil", 5.90);
    private Item pen = new Item(ItemType.OTHERS, "Pen", 50.90);
    private Item wheat = new Item(ItemType.GROCERIES, "Wheat", 150.90);
    private Item rice = new Item(ItemType.GROCERIES, "Rice", 10.90);

    private Date OLD_DATE = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
    private Date NEW_DATE = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();

    public void init(UserType userType, Date registrationDate){
        billingCalculator = new BillingCalculatorImpl();
        user = new User(userType, registrationDate, String.valueOf(++userId));
        bill = new Bill(user, items, 0);
    }

    private void printResult(double amount) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Bill amount for " + user.getUserType() + " is: " + numberFormat.format(amount));
    }

    @Test
    public void calculateAmountForEmployee(){
        items.add(pen);
        items.add(wheat);
        init(UserType.EMPLOYEE, OLD_DATE);
        printResult(billingCalculator.calculateBillAmount(bill));
    }

    @Test
    public void calculateAmountForAffiliate(){
        items.add(pen);
        items.add(wheat);
        init(UserType.AFFILIATE, OLD_DATE);
        printResult(billingCalculator.calculateBillAmount(bill));
    }

    @Test
    public void calculateAmountForOldCustomer(){
        items.add(pen);
        items.add(wheat);
        init(UserType.CUSTOMER, OLD_DATE);
        printResult(billingCalculator.calculateBillAmount(bill));
    }

    @Test
    public void calculateAmountForNewCustomer(){
        items.add(pen);
        items.add(wheat);
        init(UserType.CUSTOMER, NEW_DATE);
        printResult(billingCalculator.calculateBillAmount(bill));
    }

    @Test
    public void calculateAmountForOldCustomerNoPriceDiscount(){
        items.add(pen); // < 100
        init(UserType.CUSTOMER, OLD_DATE);
        printResult(billingCalculator.calculateBillAmount(bill));
    }

    @Test
    public void calculateAmountForNewCustomerNoDiscount(){
        items.add(pencil);
        init(UserType.EMPLOYEE, OLD_DATE);
        printResult(billingCalculator.calculateBillAmount(bill));
    }

}
