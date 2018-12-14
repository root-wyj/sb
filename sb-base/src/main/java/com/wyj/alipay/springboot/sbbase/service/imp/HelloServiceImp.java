package com.wyj.alipay.springboot.sbbase.service.imp;

import com.wyj.alipay.springboot.sbbase.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/19
 */
@Service
public class HelloServiceImp implements IHelloService {

    @Override
    public void hello() {
        System.out.println("service hello");
    }

}
