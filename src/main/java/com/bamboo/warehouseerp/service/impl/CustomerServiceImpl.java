package com.bamboo.warehouseerp.service.impl;

import com.bamboo.warehouseerp.mapper.CustomerMapper;
import com.bamboo.warehouseerp.pojo.Customer;
import com.bamboo.warehouseerp.pojo.condition.CustomerVo;
import com.bamboo.warehouseerp.service.CustomerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/28 19:47
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public IPage<Customer> selectPage(Page<Customer> pageParam, CustomerVo customerVo) {
        return customerMapper.selectPage(pageParam, customerVo);
    }
}
