package com.wyj.alipay.springboot.common.base.enums;

/**
 * Created
 * Author: wyj
 * Date: 2019/1/23
 */
public enum RedisKeyEnum {
    SESSION_USER("lps:user:%s", "session user", 60*30)
    ;


    private String key;
    private String msg;
    private long expire;

    RedisKeyEnum(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    RedisKeyEnum(String key, String msg, long expire) {
        this.key = key;
        this.msg = msg;
        this.expire = expire;
    }

    public String getKey() {
        return key;
    }

    public String getMsg() {
        return msg;
    }

    public long getExpire() {
        return expire;
    }
}
