package com.fno.retail.controller;

import com.fno.retail.Util;
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


    @RequestMapping(path = "/net-payable", method = RequestMethod.GET)
    public List<User> getNetPayableAmounts(double bill) {

        List<User> results = new ArrayList<>();

        results.add(new Employee("Employee", new Date(), bill));
        results.add(new Affiliate("Affiliate", new Date(), bill));
        results.add(new User("User - Recent", new Date(), bill));
        results.add(new User("User - + 2 years", Util.olderThanTwoYears(), bill));

        return results;
    }
    
}
