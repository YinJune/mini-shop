package com.yinjune.service;

import com.yinjune.dao.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yinjune.pojo.dto.AddressDTO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
public interface UserAddressService extends IService<UserAddress> {
    /**
     * 获取用户地址
     *
     * @param userId
     * @return
     */
    List<UserAddress> getByUserId(Integer userId);

    /**
     * 添加或更新
     *
     * @param addressDTO
     */
    void addOrUpdateAddress(AddressDTO addressDTO);

    /**
     * 转换省份编码
     *
     * @param provinceCode
     * @return
     */
    String convertProvince(String provinceCode);

    /**
     * 转换城市编码
     *
     * @param cityCode
     * @return
     */
    String convertCity(String cityCode);

    /**
     * 转换区域编码
     *
     * @param districtCode
     * @return
     */
    String convertDistrict(String districtCode);
}
