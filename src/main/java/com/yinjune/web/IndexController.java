package com.yinjune.web;

import com.yinjune.common.annotation.TraceLog;
import com.yinjune.common.result.ResultInfo;
import com.yinjune.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 13:26
 * @description:
 */
@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     * 获取首页活动
     *
     * @return
     */
    @TraceLog(desc = "首页活动")
    @GetMapping("/anon/index/activity")
    public ResultInfo getActivity() {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
}
