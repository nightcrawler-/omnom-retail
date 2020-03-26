package com.fno.retail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fno.retail.Util;

import java.util.Date;

/**
 * This is the base customer/user class that defines a standard user
 */
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
    private double totalBillAmount;

    @JsonIgnore
    private double groceriesAmount;

    private double payableAmount;

    public User(String name, Date registrationDate, double totalBillAmount, double groceriesAmount) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.totalBillAmount = totalBillAmount;
        this.groceriesAmount = groceriesAmount;

        if (groceriesAmount > totalBillAmount) {
            throw new RuntimeException("Groceries amount should not exceed the total bill amount");
        }
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
        //Get discounted amount on percent
        //Get discountent amount every 100
        //Subtract the sum of the above two from the total bill

        double discountOnPercent = (getDiscountPercentage() / 100 * getAmountWithPercentDiscount());
        double billDiscount = Math.floor(totalBillAmount / FACTOR) * DISCOUNT_FOR_EVERY_HUNDRED;

        payableAmount = totalBillAmount - (discountOnPercent + billDiscount);
        return payableAmount;
    }

    private double getAmountWithPercentDiscount() {
        return totalBillAmount - groceriesAmount;
    }
}
