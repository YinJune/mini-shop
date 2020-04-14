package com.yinjune.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinjune.dao.entity.Banner;
import com.yinjune.dao.mapper.BannerMapper;
import com.yinjune.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * banner表 服务实现类
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    /**
     * 根据位置查询banner
     *
     * @param position
     * @return
     */
    @Override
    public List<Banner> getByPosition(String position) {
        QueryWrapper<Banner> wrapper=new QueryWrapper<>();
        wrapper.eq("position",position).eq("status",1);
        return bannerMapper.selectList(wrapper);
    }
}
