package com.fno.retail.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.fno.retail.Util.olderThanTwoYears;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeTest {

    private static User veteran;
    private static User recent;

    @BeforeAll
    static void init() {
        recent = buildEmployees(false, 1000, 0);
        veteran = buildEmployees(true, 1000, 0);
    }

    @Test
    void getDiscountPercentage() {

        assertEquals(30, recent.getDiscountPercentage());
        assertEquals(30, veteran.getDiscountPercentage());
    }

    @Test
    void getNetPayableAmount() {
        assertEquals(650, recent.getNetPayableAmount());
        assertEquals(650, veteran.getNetPayableAmount());
    }

    private static Employee buildEmployees(Boolean veteran, double totalBillAmount, double groceriesAmount) {
        if (veteran) {
            return new Employee("Employee - + 2 years", olderThanTwoYears(), totalBillAmount, groceriesAmount);
        }
        return new Employee("Employee - Recent", new Date(), totalBillAmount, groceriesAmount);
    }
}