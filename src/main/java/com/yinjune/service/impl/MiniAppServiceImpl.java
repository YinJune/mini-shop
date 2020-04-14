package com.yinjune.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yinjune.common.constant.RedisKeyConstants;
import com.yinjune.common.result.ResultInfo;
import com.yinjune.common.util.RedisUtils;
import com.yinjune.common.util.mp.MpUtils;
import com.yinjune.pojo.dto.DecryptDataDTO;
import com.yinjune.pojo.dto.MpLoginResDTO;
import com.yinjune.service.MiniAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 16:42
 * @description:
 */
@Service
public class MiniAppServiceImpl implements MiniAppService {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 小程序登录
     *
     * @param jsCode
     * @return
     */
    @Override
    public MpLoginResDTO miniLogin(String jsCode) {

        return null;
    }

    /**
     * 解密数据
     *
     * @param decryptDataDTO
     * @return
     */
    @Override
    public JSONObject decryptData(DecryptDataDTO decryptDataDTO) {
        String sessionKey = redisUtils.get(RedisKeyConstants.MP_SESSION_KEY + decryptDataDTO.getOpenId());
        String decryptData = MpUtils.decrypt(decryptDataDTO.getAppId(), decryptDataDTO.getEncryptedData(), sessionKey, decryptDataDTO.getIv());
        return JSONObject.parseObject(decryptData);
    }
}
