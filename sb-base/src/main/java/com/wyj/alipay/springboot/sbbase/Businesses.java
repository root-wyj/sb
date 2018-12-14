package com.wyj.alipay.springboot.sbbase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/27
 */

@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "business")
public class Businesses {

    private String haha;

//    @Value("values")
    private List<Business> businesses;

    public String getHaha() {
        return haha;
    }

    public void setHaha(String haha) {
        this.haha = haha;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    @Override
    public String toString() {
        if (businesses != null) {
            for (Business tmp : businesses) {
                System.out.println(tmp.toString());
            }
        }
        System.out.println(businesses);
        return "[businesses] haha:"+haha;
    }
}
