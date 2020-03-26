package com.fno.retail.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.fno.retail.Util.olderThanTwoYears;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserTest {

    static User veteran;
    static User recent;
    static Bill bill = new Bill(0, 1000);

    @BeforeAll
    static void init() {
        recent = buildUsers(false, bill);
        veteran = buildUsers(true, bill);
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
    }

    @Test
    void getName() {
        assertEquals("User - + 2 years", veteran.getName());
        assertEquals("User - Recent", recent.getName());
    }

    private static User buildUsers(Boolean veteran, Bill bill) {
        if (veteran) {
            return new User("User - + 2 years", olderThanTwoYears(), bill);
        }
        return new User("User - Recent", new Date(), bill);
    }
}