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
    private static User veteranWithGroceries;

    @BeforeAll
    static void init() {
        recent = buildAffiliates(false, 1000, 0);
        veteran = buildAffiliates(true, 1000, 0);
        veteranWithGroceries = buildAffiliates(true, 1000, 500);
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
        assertEquals(900, veteranWithGroceries.getNetPayableAmount());
    }

    private static Affiliate buildAffiliates(Boolean veteran, double totalBillAmount, double groceriesAmount) {
        if (veteran) {
            return new Affiliate("Employee - + 2 years", olderThanTwoYears(), totalBillAmount, groceriesAmount);
        }
        return new Affiliate("Employee - Recent", new Date(), totalBillAmount, groceriesAmount);
    }
}