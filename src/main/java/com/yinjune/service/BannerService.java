package com.yinjune.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yinjune.dao.entity.Banner;

import java.util.List;

/**
 * <p>
 * banner表 服务类
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
public interface BannerService extends IService<Banner> {
    /**
     * 根据位置查询banner
     *
     * @param position
     * @return
     */
    List<Banner> getByPosition(String position);
}
