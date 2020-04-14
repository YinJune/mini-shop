package com.yinjune.web;

import com.yinjune.common.annotation.TraceLog;
import com.yinjune.common.result.ResultInfo;
import com.yinjune.dao.entity.Banner;
import com.yinjune.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 12:56
 * @description:
 */
@RestController
public class BannerController {
    private static final Logger logger = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    /**
     * 根据位置查询banner
     *
     * @return
     */
    @TraceLog(desc = "查询banner")
    @GetMapping("/anon/banner/query/{position}")
    public ResultInfo getBanner(@PathVariable("position")String position) {
        List<Banner> banners=bannerService.getByPosition(position);
        return new ResultInfo(banners);
    }
}
