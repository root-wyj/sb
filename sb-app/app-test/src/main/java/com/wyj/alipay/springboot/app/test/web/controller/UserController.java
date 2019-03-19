package com.wyj.alipay.springboot.app.test.web.controller;

import com.wyj.alipay.springboot.app.api.model.User;
import com.wyj.alipay.springboot.app.test.service.IUserService;
import com.wyj.alipay.springboot.common.base.enums.ApiResultCodeEnum;
import com.wyj.alipay.springboot.common.base.model.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/18
 */

@RestController
@RequestMapping("/app/test/user")
@Slf4j
public class UserController {

    @Resource
    IUserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "success";
    }

    @GetMapping("/{id}")
    public ApiResult<User> getUser(@PathVariable("id")long id) {
        log.info("UserController.getUser|获取用户信息, id:{}", id);
        try {
            return ApiResult.buildSuccess(userService.selectByKey(id));
        } catch (Exception e) {
            log.error("UserController.getUser|获取用户信息, 出错。id:{}, e:{}", id, e);
            return ApiResult.buildFail(ApiResultCodeEnum.SYSTEM_ERROR);
        }
    }
}
