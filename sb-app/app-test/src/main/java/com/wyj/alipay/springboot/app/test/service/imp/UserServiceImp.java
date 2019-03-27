package com.wyj.alipay.springboot.app.test.service.imp;

import com.wyj.alipay.springboot.app.api.model.User;
import com.wyj.alipay.springboot.app.test.mapper.UserMapper;
import com.wyj.alipay.springboot.app.test.service.IUserService;
import com.wyj.alipay.springboot.common.base.core.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */

@Service
public class UserServiceImp extends BaseService<User> implements IUserService {

    @Resource
    UserMapper mapper;

    @Override
    @Transactional
    public User selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
