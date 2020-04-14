package com.yinjune.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 12:04
 * @description:
 */
public enum SerialNoTypeEnum {
    PRODUCT_CODE("01", "商品编号"),
    SHOP_ORDER("02", "商城订单");
    private String type;
    private String desc;

    SerialNoTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
