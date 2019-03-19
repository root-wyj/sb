package com.wyj.alipay.springboot.app.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Mysql")
    private Long id;
    private String name;
    private Integer age;
    private Date create_time;
    private Date update_time;
}
