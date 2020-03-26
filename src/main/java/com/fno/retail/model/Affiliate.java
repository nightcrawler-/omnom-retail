package com.fno.retail.model;

import java.util.Date;

public class Affiliate extends User {

    private static final double DISCOUNT = 10;

    public Affiliate(String name, Date registrationDare, Bill bill) {
        super(name, registrationDare, bill);
    }

    @Override
    public double getDiscountPercentage() {
        return DISCOUNT;
    }
}
