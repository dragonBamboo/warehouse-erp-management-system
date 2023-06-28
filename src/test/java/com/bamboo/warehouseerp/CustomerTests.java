package com.bamboo.warehouseerp;

import com.bamboo.warehouseerp.pojo.Customer;
import com.bamboo.warehouseerp.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/28 19:49
 */
@SpringBootTest
public class CustomerTests {
    @Autowired
    private CustomerService customerService;

    @Test
    public void find() {
        List<Customer> list = customerService.list();
        list.forEach(System.out::println);
    }
}
