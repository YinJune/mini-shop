package com.yinjune.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinjune.common.enums.StatusEnum;
import com.yinjune.dao.entity.UserAddress;
import com.yinjune.dao.mapper.UserAddressMapper;
import com.yinjune.pojo.dto.AddressDTO;
import com.yinjune.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
@Resource
private UserAddressMapper addressMapper;
    /**
     * 获取用户地址
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getByUserId(Integer userId) {
        QueryWrapper<UserAddress> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",userId).eq("status", StatusEnum.VALID.getKey());
        return addressMapper.selectList(wrapper);
    }

    /**
     * 添加或更新
     *
     * @param addressDTO
     */
    @Override
    public void addOrUpdateAddress( AddressDTO addressDTO) {
        UserAddress address=new UserAddress();
        saveOrUpdate(address);
    }

    @Override
    public String convertProvince(String province) {
        return null;
    }

    /**
     * 转换城市编码
     *
     * @param city
     * @return
     */
    @Override
    public String convertCity(String city) {
        return null;
    }

    /**
     * 转换区域编码
     *
     * @param district
     * @return
     */
    @Override
    public String convertDistrict(String district) {
        return null;
    }
}
