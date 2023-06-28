package com.bamboo.warehouseerp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/26 10:27
 */
@Data
public class BaseEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableLogic // 逻辑删除 默认0 已删除1
    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField(exist = false)
    private Map<String, Object> param = new HashMap<>();
}