package com.bamboo.warehouseerp.service;

import com.bamboo.warehouseerp.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    User getByUserame(String username);
}
