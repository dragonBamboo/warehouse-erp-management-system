package com.bamboo.warehouseerp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/26 10:30
 */
@Data
@TableName("user")
@Accessors(chain = true)
public class User extends BaseEntity{

    private static final long serialversionUID = 1L;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;
}
