package com.wyj.alipay.springboot.others.mybatis.service.imp;

import com.wyj.alipay.springboot.others.mybatis.mapper.UserMapper;
import com.wyj.alipay.springboot.others.mybatis.model.User;
import com.wyj.alipay.springboot.others.mybatis.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */

@Service
public class UserServiceImp implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
