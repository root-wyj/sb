package com.wyj.alipay.springboot.others.mybatis.service;

import com.wyj.alipay.springboot.others.mybatis.model.User;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */
public interface IUserService {

    User selectByPrimaryKey(long id);


}
