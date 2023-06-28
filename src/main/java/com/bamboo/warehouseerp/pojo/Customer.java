package com.bamboo.warehouseerp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/28 19:33
 */
@Data
@TableName("customer")
public class Customer extends BaseEntity {
    // 客户名称
    @TableField("name")
    private String name;
//    单据编号
    @TableField("receipt_number")
    private String receiptNumber;
    // 商品信息
    @TableField("commodity_information")
    private String commodityInformation;
    // 单据日期
    @TableField("bill_date")
    private Date billDate;
    // 操作员
    @TableField("operator")
    private String operator;
    // 金额合计
    @TableField("total_amount")
    private Double totalAmount;
    // 状态
    @TableField("state")
    private String state;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", commodityInformation='" + commodityInformation + '\'' +
                ", billDate=" + billDate +
                ", operator='" + operator + '\'' +
                ", totalAmount=" + totalAmount +
                ", state='" + state + '\'' +
                "} " + super.toString();
    }
}
