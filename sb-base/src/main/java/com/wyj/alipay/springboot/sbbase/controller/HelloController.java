package com.wyj.alipay.springboot.sbbase.controller;

import com.wyj.alipay.springboot.sbbase.service.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/10/31
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    Environment environment;

    @Autowired
    IHelloService helloService;

    @Value("${wyj.config.name}-----lol")
    String configValue;

    @PostConstruct
    public void testAfterCreate() {
        helloService.hello();
    }

    @GetMapping(value="/hello")
    public String hello(@RequestParam(name = "key", defaultValue = "defaultKey")String key) {
        logger.info("user.dir:" + System.getProperty("user.dir"));
        logger.info("java.version:" + System.getProperty("java.version"));
        logger.info("project.build.sourceEncoding:" + System.getProperty("project.build.sourceEncoding"));
        System.getProperties();

        helloService.hello();

        logger.info("env-wyj.config.name:" + environment.getProperty("wyj.config.name"));
        logger.info("env-project.build.sourceEncoding:" + environment.getProperty("project.build.sourceEncoding"));

        logger.info("env-wyj.config.name:" + environment.getProperty("business_version"));

        return "hello " + key + ", configValue:" + configValue;
    }

}
