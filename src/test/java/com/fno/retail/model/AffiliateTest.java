package com.fno.retail.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.fno.retail.Util.olderThanTwoYears;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AffiliateTest {

    private static User veteran;
    private static User recent;
    private static Bill bill = new Bill(0, 1000);

    @BeforeAll
    static void init() {
        recent = buildAffiliates(false, bill);
        veteran = buildAffiliates(true, bill);
    }

    @Test
    void getDiscountPercentage() {

        assertEquals(10, recent.getDiscountPercentage());
        assertEquals(10, veteran.getDiscountPercentage());
    }

    @Test
    void getNetPayableAmount() {
        assertEquals(850, recent.getNetPayableAmount());
        assertEquals(850, veteran.getNetPayableAmount());
    }
    private static Affiliate buildAffiliates(Boolean veteran, Bill bill) {
        if (veteran) {
             return new Affiliate("Employee - + 2 years", olderThanTwoYears(), bill);
        }
        return new Affiliate("Employee - Recent", new Date(), bill);
    }
}