package com.wyj.alipay.springboot.app.test;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/18
 */

@SpringBootApplication
@PropertySource(value = {"classpath:/properties.properties"})
@ConfigurationProperties(prefix = "wu.test.app")
//@EnableConfigurationProperties(value = AppTestApplication.class)
@Slf4j
@NoArgsConstructor
@Data
public class AppTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppTestApplication.class, args);
    }


    private String name;

    private Integer age;

    @Resource
    Environment env;

    @Override
    public void run(String... args) throws Exception {
        log.info("AppTestApplication.run|name:{}, age:{}", getName(), getAge());

        log.info("name:{}, age:{}", env.getProperty("wu.test.app.name"), env.getProperty("wu.test.app.age"));
    }
}
