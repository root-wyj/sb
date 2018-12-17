package com.wyj.alipay.springboot.sbbase.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created
 * Author: wyj
 * Date: 2018/12/17
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * shutdown 需要 ACTUATOR_ADMIN 的角色
     * 其他的endpoint 都会允许
     * 静态资源都会允许
     * homepage 都允许
     * 其他的需要权限
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.to(ShutdownEndpoint.class)).hasRole("ACTUATOR_ADMIN")
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/**").authenticated()
            .and()
            .httpBasic();

    }
}
