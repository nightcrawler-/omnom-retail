package com.fno.retail.controller;

import com.fno.retail.Util;
import com.fno.retail.model.Bill;
import com.fno.retail.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RetailController {


    @PostMapping(path = "/net-payable", headers="Accept=application/json")
    public @ResponseBody
    List<User> getNetPayableAmounts(@RequestBody Bill bill) {
        return Util.generateResults(bill);
    }

}
