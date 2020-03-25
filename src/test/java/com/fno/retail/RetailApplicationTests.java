package com.fno.retail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetailApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void main() {
    	//This test is essentially to increase the coverage metrics, is not really necessary
        RetailApplication.main(new String[]{""});
    }

}
