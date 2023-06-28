package com.bamboo.warehouseerp;

import com.bamboo.warehouseerp.pojo.Goods;
import com.bamboo.warehouseerp.pojo.User;
import com.bamboo.warehouseerp.service.GoodsService;
import com.bamboo.warehouseerp.service.UserService;
import com.bamboo.warehouseerp.util.encryption.MD5;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
@MapperScan("com.bamboo.warehouseerp.mapper")
class MainApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = userService.getByUserame(MD5.encrypt("admin"));
        System.out.println(user);
    }
    @Test
    void save(){
        User user = new User();
        user.setName("zhangsan").setUsername("zhangsans").setPassword("123456").setPhone("188341111").setEmail("yyy@qq.com");
        userService.save(user);
        List<User> list = userService.list(null);
        list.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });
    }

    @Autowired
    private GoodsService goodsService;
    @Test
    void listGoods() {
        for (Goods goods : goodsService.list()) {
            System.out.println(goods);
        }

    }

}
