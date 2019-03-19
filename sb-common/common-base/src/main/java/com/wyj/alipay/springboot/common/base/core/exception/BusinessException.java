package com.wyj.alipay.springboot.common.base.core.exception;


import com.wyj.alipay.springboot.common.base.enums.ApiResultCodeEnum;

/**
 * 业务异常
 * Created
 * Author: wyj
 * Date: 2019/1/20
 */
public class BusinessException extends RuntimeException{

    protected String code = ApiResultCodeEnum.SYSTEM_ERROR.code();

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String code, String msg, Throwable throwable) {
        super(msg, throwable);
        this.code = code;
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(ApiResultCodeEnum apiResultCodeEnum) {
        this(apiResultCodeEnum.code(), apiResultCodeEnum.msg());
    }

}
