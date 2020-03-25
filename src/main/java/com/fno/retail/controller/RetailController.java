package com.fno.retail.controller;

import com.fno.retail.model.Affiliate;
import com.fno.retail.model.Employee;
import com.fno.retail.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RetailController {


    @RequestMapping(path = "/discount", method = RequestMethod.GET)
    public List<User> getDiscount(double bill) {
        //return all user types with net payable?

        List<User> results = new ArrayList<>();

        results.add(new Employee("Employee", new Date(), bill));
        results.add(new Affiliate("Affiliate", new Date(), bill));
        results.add(new User("User - Recent", new Date(), bill));
        results.add(new User("User - + 2 years", olderThanTwoYears(), bill));

        return results;
    }

    private Date olderThanTwoYears() {
        Date then = new Date();
        then.setTime(2 * 370 * 24 * 60 * 60 * 1000);
        return then;

    }

}
