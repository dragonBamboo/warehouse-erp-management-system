package com.bamboo.warehouseerp.service.impl;

import com.bamboo.warehouseerp.mapper.GoodsMapper;
import com.bamboo.warehouseerp.pojo.Goods;
import com.bamboo.warehouseerp.pojo.condition.GoodsVo;
import com.bamboo.warehouseerp.service.GoodsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/27 15:06
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public IPage<Goods> selectPage(Page<Goods> pageParam, GoodsVo goodsVo) {
        return goodsMapper.selectPage(pageParam,goodsVo);
    }
}
