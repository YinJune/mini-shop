package com.yinjune.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 15:18
 * @description:
 */
@Data
public class DecryptDataDTO {
    /**
     * 加密数据
     */
    @NotEmpty(message = "加密数据不能为空")
    private String encryptedData;
    private String signature;
    private String rawData;
    private String sessionKey;
    private String appId;
    /**
     * openid
     */
    @NotEmpty(message = "openId不能为空")
    private String openId;
    /**
     * iv
     */
    @NotEmpty(message = "iv不能为空")
    private String iv;
}
