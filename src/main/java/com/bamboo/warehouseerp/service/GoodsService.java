package com.bamboo.warehouseerp.service;

import com.bamboo.warehouseerp.pojo.Goods;
import com.bamboo.warehouseerp.pojo.condition.GoodsVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface GoodsService extends IService<Goods> {
    IPage<Goods> selectPage(Page<Goods> pageParam, GoodsVo goodsVo);
}
