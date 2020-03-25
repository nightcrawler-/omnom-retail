package com.fno.retail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UtilTest {

    @Test
    void getDiffYears() {
        Date jan2020 = new Date();
        jan2020.setYear(2020);
        jan2020.setMonth(1);

        Date jan2018 = new Date();
        jan2018.setYear(2018);
        jan2018.setMonth(1);

        Date feb2018 = new Date();
        feb2018.setYear(2018);
        feb2018.setMonth(2);

        assertEquals(2, Util.getDiffYears(jan2018, jan2020));
        assertEquals(1, Util.getDiffYears(feb2018, jan2020));
    }
}