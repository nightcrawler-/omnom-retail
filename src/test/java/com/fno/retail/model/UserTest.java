package com.fno.retail.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.fno.retail.Util.olderThanTwoYears;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserTest {

    private static User veteran;
    private static User recent;

    @BeforeAll
    static void init() {
        recent = buildUsers(false, 1000);
        veteran = buildUsers(true, 1000);
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

    private static User buildUsers(Boolean veteran, double bill) {
        if (veteran) {
            return new User("User - + 2 years", olderThanTwoYears(), bill);
        }
        return new User("User - Recent", new Date(), bill);
    }
}