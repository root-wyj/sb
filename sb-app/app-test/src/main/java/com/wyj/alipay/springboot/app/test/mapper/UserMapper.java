package com.wyj.alipay.springboot.app.test.mapper;

import com.wyj.alipay.springboot.app.api.model.User;
import com.wyj.alipay.springboot.common.base.core.mybatis.IMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */

@Mapper
public interface UserMapper extends IMapper<User> {

}
