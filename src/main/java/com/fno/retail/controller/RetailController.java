package com.fno.retail.controller;

import com.fno.retail.Util;
import com.fno.retail.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetailController {

    @RequestMapping(path = "/net-payable", method = RequestMethod.GET)
    public List<User> getNetPayableAmounts(double totalBillAmount, double groceriesAmount) {
        return Util.generateResults(totalBillAmount, groceriesAmount);
    }
    
}
