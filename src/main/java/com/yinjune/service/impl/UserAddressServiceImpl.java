package com.yinjune.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinjune.common.enums.StatusEnum;
import com.yinjune.dao.entity.City;
import com.yinjune.dao.entity.District;
import com.yinjune.dao.entity.Province;
import com.yinjune.dao.entity.UserAddress;
import com.yinjune.dao.mapper.CityMapper;
import com.yinjune.dao.mapper.DistrictMapper;
import com.yinjune.dao.mapper.ProvinceMapper;
import com.yinjune.dao.mapper.UserAddressMapper;
import com.yinjune.pojo.dto.AddressDTO;
import com.yinjune.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
    @Resource
    private UserAddressMapper addressMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private ProvinceMapper provinceMapper;
    @Resource
    private DistrictMapper districtMapper;

    /**
     * 获取用户地址
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getByUserId(Integer userId) {
        QueryWrapper<UserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).eq("status", StatusEnum.VALID.getKey());
        return addressMapper.selectList(wrapper);
    }

    /**
     * 添加或更新
     *
     * @param addressDTO
     */
    @Override
    public void addOrUpdateAddress(AddressDTO addressDTO) {
        UserAddress address = new UserAddress();
        saveOrUpdate(address);
    }

    /**
     * 转换省份编码
     *
     * @param provinceCode
     * @return
     */
    @Override
    public String convertProvince(String provinceCode) {
        QueryWrapper<Province> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", provinceCode);
        return provinceMapper.selectOne(queryWrapper).getProvince();
    }

    /**
     * 转换城市编码
     *
     * @param cityCode
     * @return
     */
    @Override
    public String convertCity(String cityCode) {
        QueryWrapper<City> wrapper = new QueryWrapper<>();
        wrapper.eq("code", cityCode);
        return cityMapper.selectOne(wrapper).getCity();
    }

    /**
     * 转换区域编码
     *
     * @param districtCode
     * @return
     */
    @Override
    public String convertDistrict(String districtCode) {
        QueryWrapper<District> wrapper = new QueryWrapper<>();
        wrapper.eq("code", districtCode);
        return districtMapper.selectOne(wrapper).getDistrict();
    }
}
