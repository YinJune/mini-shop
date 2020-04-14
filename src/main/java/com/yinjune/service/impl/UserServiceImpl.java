package com.yinjune.service.impl;

import com.yinjune.dao.entity.User;
import com.yinjune.dao.mapper.UserMapper;
import com.yinjune.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author YinJune
 * @since 2020-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
