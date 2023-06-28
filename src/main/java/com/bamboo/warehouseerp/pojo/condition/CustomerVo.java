package com.bamboo.warehouseerp.pojo.condition;

import lombok.Data;

import java.util.Date;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/28 19:54
 */
@Data
public class CustomerVo {
    // 单据编号
    private String receiptNumber;
    // 商品信息
    private String commodityInformation;
    // 单据日期
    private Date oldDate;
    private Date newDate;
}
