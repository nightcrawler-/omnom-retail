package com.fno.retail.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fno.retail.Util;
import com.fno.retail.model.Bill;
import com.fno.retail.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RetailController.class)
class RetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getNetPayableAmounts() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/net-payable").content(objectMapper.writeValueAsString(new Bill(0,1000)))).andExpect(status().isOk()).andReturn();

        List<User> expected = Util.generateResults(new Bill(0, 1000));
        List<User> actualResponseBody = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);

        List<User> response = objectMapper.convertValue(actualResponseBody, new TypeReference<List<User>>() {
        });

        assertThat(expected.get(0).getName()).isEqualTo(response.get(0).getName());
        assertThat(expectedResponse()).isEqualTo(mvcResult.getResponse().getContentAsString());
    }

    private String expectedResponse() {
        return "[{\"name\":\"Employee\",\"net_payable_amount\":650.0},{\"name\":\"Affiliate\",\"net_payable_amount\":850.0},{\"name\":\"User - Recent\",\"net_payable_amount\":950.0},{\"name\":\"User - + 2 years\",\"net_payable_amount\":900.0}]";
    }
}