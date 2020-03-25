package com.fno.retail.model;

import java.util.Date;

public class Affiliate extends User {

    private static final float DISCOUNT = 10;

    public Affiliate(String name, Date registrationDare, double bill) {
        super(name, registrationDare, bill);
    }

    @Override
    public float getDiscountPercentage() {
        return DISCOUNT;
    }
}
