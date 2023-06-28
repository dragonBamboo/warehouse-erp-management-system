package com.bamboo.warehouseerp.controller;

import com.bamboo.warehouseerp.pojo.User;
import com.bamboo.warehouseerp.service.UserService;
import com.bamboo.warehouseerp.util.encryption.JwtHelper;
import com.bamboo.warehouseerp.util.encryption.MD5;
import com.bamboo.warehouseerp.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/26 9:31
 */
@RestController
@RequestMapping("/api/lc")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody User loginUser) {
        String username = MD5.encrypt(loginUser.getUsername());
        String password = MD5.encrypt(loginUser.getPassword());
        User user = userService.getByUserame(username);
        if (user == null) {
            return Result.fail();
        } else {
            if (user.getPassword().equals(password)) {
                Map<String, Object> maps = new HashMap<>();
                String token = JwtHelper.createToken(user.getId(), user.getUsername());
                maps.put("token", token);
                maps.put("name", user.getName());
                return Result.ok(maps);
            } else {
                return Result.fail();
            }
        }
    }

    @PostMapping("register")
    public Result register(@RequestBody User user) {
        String usernameMD5 = MD5.encrypt(user.getUsername());
        String passwordMD5 = MD5.encrypt(user.getPassword());
        user.setUsername(usernameMD5).setPassword(passwordMD5);
        userService.save(user);
        return Result.ok();
    }
}
