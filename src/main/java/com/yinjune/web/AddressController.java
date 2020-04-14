package com.yinjune.web;

import com.alibaba.fastjson.JSONObject;
import com.yinjune.common.annotation.TraceLog;
import com.yinjune.common.result.ResultInfo;
import com.yinjune.dao.entity.UserAddress;
import com.yinjune.pojo.dto.AddressDTO;
import com.yinjune.pojo.vo.AddressVO;
import com.yinjune.service.UserAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/4/14 18:51
 * @description:
 */
@RestController
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private UserAddressService addressService;

    /**
     * 收货地址列表
     *
     * @param request
     * @return
     */
    @TraceLog(desc = "收货地址列表")
    @GetMapping("/user/address/list")
    public ResultInfo getUserAddressList(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("收货地址列表:{}", userId);
        List<UserAddress> addressList = addressService.getByUserId(userId);
        resultInfo.setData(addressList);
        return resultInfo;
    }

    /**
     * 收货地址详情
     *
     * @param request
     * @return
     */
    @TraceLog(desc = "收货地址详情")
    @GetMapping("/user/address/detail")
    public ResultInfo getUserAddressDetail(HttpServletRequest request, @RequestParam("addressId") Integer addressId) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("收货地址列表:{}", userId);
        UserAddress address = addressService.getById(addressId);
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(address, addressVO);
        addressVO.setProvinceWord(addressService.convertProvince(addressVO.getProvinceCode()));
        addressVO.setCityWord(addressService.convertCity(addressVO.getCityCode()));
        addressVO.setDistrictWord(addressService.convertDistrict(addressVO.getDistrictCode()));
        resultInfo.setData(addressVO);
        return resultInfo;
    }

    /**
     * 添加收货地址
     *
     * @param request
     * @return
     */
    @TraceLog(desc = "添加或更新收货地址")
    @PostMapping("/user/address/addOrUpdate")
    public ResultInfo addOrUpdateAddress(HttpServletRequest request, @RequestBody AddressDTO addressDTO) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("添加收货地址:{}", JSONObject.toJSONString(addressDTO));
        addressDTO.setUserId(userId);
        addressService.addOrUpdateAddress(addressDTO);
        return resultInfo;
    }
}
