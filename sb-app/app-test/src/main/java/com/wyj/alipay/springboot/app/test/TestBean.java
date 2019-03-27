package com.wyj.alipay.springboot.app.test;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/21
 */

//@Component
//@ConfigurationProperties(prefix = "wyj.test.app")
//@PropertySource("classpath:properties.properties")
@NoArgsConstructor
@Data
public class TestBean {

    private String name;

    private Integer age;
}
