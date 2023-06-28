package com.bamboo.warehouseerp.mapper;

import com.bamboo.warehouseerp.pojo.Customer;
import com.bamboo.warehouseerp.pojo.condition.CustomerVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
    IPage<Customer> selectPage(Page<Customer> pageParam,@Param("vo") CustomerVo customerVo);
}
