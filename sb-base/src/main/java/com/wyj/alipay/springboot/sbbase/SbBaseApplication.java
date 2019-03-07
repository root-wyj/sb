package com.wyj.alipay.springboot.sbbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class SbBaseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SbBaseApplication.class, args);
    }

    @Autowired
    Environment env;

    @Autowired
    Businesses business;

    @Override
    public void run(String... args) throws Exception {
//        Business ret = env.getProperty("business_version", Business.class);

        System.out.println(env.getProperty("business_version"));
        System.out.println(env.getProperty("business_version.type_code"));
        System.out.println(env.getProperty("wyj.config.name"));
        System.out.println(env.getProperty("wyj.config.value"));

        System.out.println(business);
    }

}
