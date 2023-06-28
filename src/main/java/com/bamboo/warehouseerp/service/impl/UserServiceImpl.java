package com.bamboo.warehouseerp.service.impl;


import com.bamboo.warehouseerp.mapper.UserMapper;
import com.bamboo.warehouseerp.pojo.User;
import com.bamboo.warehouseerp.service.UserService;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/26 16:06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUserame(String username) {
        LambdaQueryChainWrapper<User> wrapper = new LambdaQueryChainWrapper<>(userMapper);
        wrapper.eq(User::getUsername, username);
        User user = wrapper.one();
        return user;
    }
}
