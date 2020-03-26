package com.fno.retail.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bill {

    private double groceriesAmount;
    private double totalAmount;

    private double percentageBasedDiscountableAmount;

    public Bill(double groceriesAmount, double totalAmount) {
        this.groceriesAmount = groceriesAmount;
        this.totalAmount = totalAmount;

        if (groceriesAmount > totalAmount) {
            throw new RuntimeException("Groceries amount cannot exceed the total amount");
        }
    }

    public double getPercentageBasedDiscountableAmount() {
        return totalAmount - groceriesAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
