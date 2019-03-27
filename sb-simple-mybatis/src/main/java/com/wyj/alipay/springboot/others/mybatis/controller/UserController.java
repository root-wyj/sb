package com.wyj.alipay.springboot.others.mybatis.controller;

import com.wyj.alipay.springboot.others.mybatis.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/19
 */


@RestController
@RequestMapping("/sb/mybatis/user")
public class UserController {

    @Resource
    IUserService userService;

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id")long id) {
        return userService.selectByPrimaryKey(id).toString();
    }

}
