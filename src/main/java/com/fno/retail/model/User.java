package com.fno.retail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fno.retail.Util;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {

    private static double FACTOR = 100;

    private static double DISCOUNT_FOR_EVERY_HUNDRED = 5;

    private String name;

    @JsonIgnore
    private Date registrationDate;

    @JsonIgnore
    private double discountPercentage = 0;

    @JsonIgnore
    private double bill;

    private double payableAmount;

    public User(String name, Date registrationDate, double bill) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.bill = bill;
    }

    @JsonIgnore
    public double getDiscountPercentage() {
        if (Util.getDiffYears(registrationDate, new Date()) >= 2) {
            return 5;
        }
        return discountPercentage;
    }

    public String getName() {
        return name;
    }

    public double getNetPayableAmount() {
        double payableOnPercent = bill - (getDiscountPercentage()/100 * bill);
        double billDiscount = Math.floor(bill / FACTOR) * DISCOUNT_FOR_EVERY_HUNDRED;
        payableAmount =  payableOnPercent - billDiscount;
        return payableAmount;
    }
}
