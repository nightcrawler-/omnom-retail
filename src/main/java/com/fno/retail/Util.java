package com.fno.retail;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

public class Util {


    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    //Used specifically to generate a veteran user
    public static Date olderThanTwoYears() {
        Date then = new Date();
        then.setTime(2 * 370 * 24 * 60 * 60 * 1000);
        return then;

    }
}