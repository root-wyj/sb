package com.wyj.alipay.springboot.common.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created
 * Author: wyj
 * Date: 2019/1/8
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasePageQuery {

    private int pageNum = 1;
    private int pageSize = 20;
    private String orderByField = "create_time";
    private String order = "desc";
}
