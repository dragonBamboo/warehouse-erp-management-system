package com.bamboo.warehouseerp.mapper;

import com.bamboo.warehouseerp.pojo.Goods;
import com.bamboo.warehouseerp.pojo.condition.GoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    IPage<Goods> selectPage(Page<Goods> pageParam,@Param("vo") GoodsVo goodsVo);
}
