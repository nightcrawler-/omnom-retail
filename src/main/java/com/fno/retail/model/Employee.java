package com.fno.retail.model;

import java.util.Date;

public class Employee extends User {

    private static final double DISCOUNT = 30;

    public Employee(String name, Date registrationDate, double totalBillAmount, double groceriesAmount) {
        super(name, registrationDate, totalBillAmount, groceriesAmount);
    }

    @Override
    public double getDiscountPercentage() {
        return DISCOUNT;
    }
}
