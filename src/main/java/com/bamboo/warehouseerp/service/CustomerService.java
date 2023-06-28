package com.bamboo.warehouseerp.service;

import com.bamboo.warehouseerp.pojo.Customer;
import com.bamboo.warehouseerp.pojo.condition.CustomerVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CustomerService extends IService<Customer> {
    IPage<Customer> selectPage(Page<Customer> pageParam, CustomerVo customerVo);
}
