package com.fno.retail;

import com.fno.retail.model.Affiliate;
import com.fno.retail.model.Bill;
import com.fno.retail.model.Employee;
import com.fno.retail.model.User;

import java.util.*;

import static java.util.Calendar.*;

public class Util {

    /**
     * Return the years between the dates
     * @param first the earlier date
     * @param last the later date
     * @return
     */
    public static int getDiffYears(Date first, Date last) {
        Calendar firstCalendar = getCalendar(first);
        Calendar lastCalendar = getCalendar(last);
        int diff = lastCalendar.get(YEAR) - firstCalendar.get(YEAR);
        if (firstCalendar.get(MONTH) > lastCalendar.get(MONTH) || (firstCalendar.get(MONTH) == lastCalendar.get(MONTH) && firstCalendar.get(DATE) > lastCalendar.get(DATE))) {
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

    public static List<User> generateResults(Bill bill){
        List<User> results = new ArrayList<>();

        results.add(new Employee("Employee", new Date(), bill));
        results.add(new Affiliate("Affiliate", new Date(), bill));
        results.add(new User("User - Recent", new Date(), bill));
        results.add(new User("User - + 2 years", Util.olderThanTwoYears(), bill));

        return results;
    }
}
