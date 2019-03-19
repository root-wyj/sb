package com.wyj.alipay.springboot.common.base.core.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created
 * Author: wyj
 * Date: 2019/1/20
 */
public interface IMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
