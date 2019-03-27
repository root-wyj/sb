package com.wyj.alipay.springboot.others.mybatis.mapper;

import com.wyj.alipay.springboot.others.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */

@Mapper
public interface UserMapper {

    User selectByPrimaryKey(Long id);

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);

}
