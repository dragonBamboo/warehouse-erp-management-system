package com.bamboo.warehouseerp.controller;

import com.bamboo.warehouseerp.pojo.Goods;
import com.bamboo.warehouseerp.pojo.condition.GoodsVo;
import com.bamboo.warehouseerp.service.GoodsService;
import com.bamboo.warehouseerp.util.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/27 15:13
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    // 查询所有数据
    @GetMapping("list")
    public Result getList() {
        List<Goods> list = goodsService.list();
        return Result.ok(list);
    }

    // 分页查询实现
    @GetMapping("{page}/{limit}")
    public Result getPageList(
            @PathVariable(name = "page") Long page,
            @PathVariable(name = "limit") Long limit,
            GoodsVo goodsVo
    ) {
        // 测试goodsVo数据
        // System.out.println(goodsVo);
        Page<Goods> pageParam = new Page<>(page, limit);
        IPage<Goods> pageModel = goodsService.selectPage(pageParam, goodsVo);
        return Result.ok(pageModel);
    }

    @GetMapping("get/{id}")
    public Result getGoodsById(@PathVariable("id") String id) {
        Goods goods = goodsService.getById(id);
        return Result.ok(goods);
    }

    @PostMapping("add")
    public Result addGoods(@RequestBody Goods goods) {
        boolean save = goodsService.save(goods);
        return Result.ok();
    }

    @PutMapping("update")
    public Result updateGoods(@RequestBody Goods goods) {
        goodsService.updateById(goods);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result removeGoodsById(@PathVariable("id") String id) {
        goodsService.removeById(id);
        return Result.ok();
    }
}
