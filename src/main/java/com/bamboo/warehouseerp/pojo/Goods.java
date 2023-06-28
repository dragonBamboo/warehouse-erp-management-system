package com.bamboo.warehouseerp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @version v1.0
 * @auther Bamboo
 * @create 2023/6/27 14:41
 */
@Data
@Accessors(chain = true)
@TableName("goods")
public class Goods extends BaseEntity{
    // 货品类型
    @TableField("goods_category")
    private String goodsCategory;
    // 货品编码
    @TableField("goods_code")
    private Integer goodsCode;
    // 货品名称
    @TableField("goods_name")
    private String goodsName;
    // 规格型号
    @TableField("specifications")
    private String specifications;
    // 单位
    @TableField("unit")
    private String unit;
    // 参考进价
    @TableField("purchase_price")
    private Double purchasePrice;
    // 参考售价
    @TableField("selling_price")
    private Double sellingPrice;
    // 库存
    @TableField("repertory")
    private Integer repertory;
    // 所在仓库编号
    @TableField("warehouse_id")
    private String warehouseId;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsCategory='" + goodsCategory + '\'' +
                ", goodsCode=" + goodsCode +
                ", goodsName='" + goodsName + '\'' +
                ", specifications='" + specifications + '\'' +
                ", unit=" + unit +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", repertory=" + repertory +
                ", warehouseId='" + warehouseId + '\'' +
                "} " + super.toString();
    }
}
