package com.yinjune.web;

import com.alibaba.fastjson.JSONObject;
import com.yinjune.common.annotation.TraceLog;
import com.yinjune.common.result.ResultInfo;
import com.yinjune.pojo.dto.DecryptDataDTO;
import com.yinjune.pojo.dto.MpLoginResDTO;
import com.yinjune.service.MiniAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 14:23
 * @description:
 */
@RestController
public class MiniAppController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MiniAppService miniAppService;


    /**
     * 小程序登陆
     *
     * @return
     */
    @TraceLog(desc = "小程序登录")
    @GetMapping("/anon/wechat/mini/login")
    public ResultInfo miniLogin(@RequestParam("jsCode") String jsCode) {
        logger.info("小程序登陆:jsCode={}", jsCode);
        ResultInfo resultInfo = new ResultInfo();
        MpLoginResDTO mpLoginResDTO = miniAppService.miniLogin(jsCode);
        resultInfo.setData(mpLoginResDTO);
        return resultInfo;
    }
    /**
     * 小程序登陆
     *
     * @return
     */
    @TraceLog(desc = "小程序解密数据")
    @PostMapping("/anon/wx/mini/decrypt")
    public ResultInfo decryptData(@RequestBody @Validated DecryptDataDTO decryptDataDTO) {
        logger.info("小程序解密数据:decryptUserInfoReqDTO={}", JSONObject.toJSONString(decryptDataDTO));
        ResultInfo resultInfo = new ResultInfo();
        JSONObject jsonObject = miniAppService.decryptData(decryptDataDTO);
        resultInfo.setData(jsonObject);
        logger.info("解密后数据为:{}", jsonObject.toJSONString());
        return resultInfo;
    }
}
