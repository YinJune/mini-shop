package com.yinjune.service;

import com.alibaba.fastjson.JSONObject;
import com.yinjune.pojo.dto.DecryptDataDTO;
import com.yinjune.pojo.dto.MpLoginResDTO;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 16:42
 * @description:
 */
public interface MiniAppService {
    /**
     * 小程序登录
     *
     * @param jsCode
     * @return
     */
    MpLoginResDTO miniLogin(String jsCode);

    /**
     * 解密数据
     *
     * @param decryptDataDTO
     * @return
     */
    JSONObject decryptData(DecryptDataDTO decryptDataDTO);
}
