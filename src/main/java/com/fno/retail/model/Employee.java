package com.fno.retail.model;

import java.util.Date;

public class Employee extends User {

    private static final float DISCOUNT = 30;

    public Employee(String name, Date registrationDare, double bill) {
        super(name, registrationDare, bill);
    }


    @Override
    public float getDiscountPercentage() {
        return DISCOUNT;
    }
}
