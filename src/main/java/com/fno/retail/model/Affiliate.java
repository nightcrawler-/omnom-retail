package com.fno.retail.model;

import java.util.Date;

public class Affiliate extends User {

    private static final double DISCOUNT = 10;

    public Affiliate(String name, Date registrationDate, double totalBillAmount, double groceriesAmount) {
        super(name, registrationDate, totalBillAmount, groceriesAmount);
    }

    @Override
    public double getDiscountPercentage() {
        return DISCOUNT;
    }
}
