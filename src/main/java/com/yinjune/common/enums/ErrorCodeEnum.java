package com.yinjune.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 15:10
 * @description:
 */
public enum ErrorCodeEnum {
    /**
     * eg:001001001
     * 前三位 系统 中间 模块 后三位 具体
     */
    SUCCESS("000000", "请求成功"),
    SYS_ERROR("999999", "系统开小差了");
    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
