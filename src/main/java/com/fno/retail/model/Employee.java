package com.fno.retail.model;

import java.util.Date;

public class Employee extends User {

    private static final double DISCOUNT = 30;

    public Employee(String name, Date registrationDare, Bill bill) {
        super(name, registrationDare, bill);
    }


    @Override
    public double getDiscountPercentage() {
        return DISCOUNT;
    }
}
