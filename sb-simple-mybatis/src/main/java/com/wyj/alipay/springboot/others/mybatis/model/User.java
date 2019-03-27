package com.wyj.alipay.springboot.others.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private Long id;
    private String name;
    private Integer age;
    private Date create_time;
    private Date update_time;
}
