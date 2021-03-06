package com.fno.retail.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.fno.retail.Util.olderThanTwoYears;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    private static User veteran;
    private static User recent;
    private static User veteranWithGroceries;


    @BeforeAll
    static void init() {
        recent = buildUsers(false, 1000, 0);
        veteran = buildUsers(true, 1000, 0);
        veteranWithGroceries = buildUsers(true, 1000, 500);

    }

    @Test
    void getDiscountPercentage() {

        assertEquals(0, recent.getDiscountPercentage());
        assertEquals(5, veteran.getDiscountPercentage());
    }

    @Test
    void getNetPayableAmount() {
        assertEquals(950, recent.getNetPayableAmount());
        assertEquals(900, veteran.getNetPayableAmount());
        assertEquals(925, veteranWithGroceries.getNetPayableAmount());
    }

    @Test
    void getName() {
        assertEquals("User - + 2 years", veteran.getName());
        assertEquals("User - Recent", recent.getName());
    }

    @Test
    void User() {
        Exception ex = assertThrows(RuntimeException.class, () -> {
            new User("User", new Date(), 0, 1000);
        });
        assertTrue(ex.getMessage().contains("Groceries amount should not exceed the total bill amount"));
    }

    private static User buildUsers(Boolean veteran, double totalBillAmount, double groceriesAmount) {
        if (veteran) {
            return new User("User - + 2 years", olderThanTwoYears(), totalBillAmount, groceriesAmount);
        }
        return new User("User - Recent", new Date(), totalBillAmount, groceriesAmount);
    }
}