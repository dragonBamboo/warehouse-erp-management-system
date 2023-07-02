package com.bamboo.warehouseerp.controller;

import com.bamboo.warehouseerp.pojo.Customer;
import com.bamboo.warehouseerp.pojo.condition.CustomerVo;
import com.bamboo.warehouseerp.service.CustomerService;
import com.bamboo.warehouseerp.util.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/28 19:52
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("findAll")
    public Result findAll() {
        List<Customer> list = customerService.list();
        return Result.ok(list);
    }

    @GetMapping("{page}/{limit}")
    public Result getPageList(
            @PathVariable("page") Long page,
            @PathVariable("limit") Long limit,
            CustomerVo customerVo
    ) {
        if ("".equals(customerVo.getOldDate())) {
            customerVo.setOldDate(customerVo.getOldDate().replace("%20", " ").replace("%3A", ":"));
        }
        if ("".equals(customerVo.getNewDate())) {
            customerVo.setNewDate(customerVo.getNewDate().replace("%20", " ").replace("%3A", ":"));
        }
        Page<Customer> pageParam = new Page<>(page, limit);
        IPage<Customer> pageModel = customerService.selectPage(pageParam, customerVo);
        return Result.ok(pageModel);
    }

    @GetMapping("get/{id}")
    public Result getCustomerById(@PathVariable("id") String id) {
        Customer customer = customerService.getById(id);
        return Result.ok(customer);
    }

    @PostMapping("add")
    public Result addCustomer(@RequestBody Customer customer) {
        boolean save = customerService.save(customer);
        return Result.ok();
    }

    @PutMapping("update")
    public Result updateCustomer(@RequestBody Customer customer) {
        customerService.updateById(customer);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result removeCustomerById(@PathVariable("id") String id) {
        customerService.removeById(id);
        return Result.ok();
    }

}
