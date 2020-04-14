package com.yinjune.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yinjune.dao.entity.Banner;
import com.yinjune.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 12:27
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BannerTests {
    @Autowired
    private BannerService bannerService;

    @Test
    public void testInsert(){
        Banner banner=new Banner();
        banner.setName("测试banner");
        assert(bannerService.save(banner)) ;
    }
    @Test
    public void testQuery(){
        Banner banner=new Banner();
        banner.setName("测试banner");
        QueryWrapper<Banner> wrapper=new QueryWrapper<>();
        wrapper.eq("name","测试banner");
        Banner b=bannerService.getOne(wrapper);
        assert ("测试banner".equals(b.getName()));
    }
}
