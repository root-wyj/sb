package com.wyj.alipay.springboot.common.base.model;

import com.wyj.alipay.springboot.common.base.enums.ApiResultCodeEnum;
import lombok.Data;


/***
 * 功能: apiResult 定义code 统一通过 ApiResultCodeEnum 枚举
 * @see com.wyj.alipay.springboot.common.base.enums.ApiResultCodeEnum
 **/
@Data
public class ApiResult<T>{


    private ApiResult() {
    }

    private String code;
    private String message;
    private Long timestamp;
    private T data;


    public boolean isSucc(){
        return ApiResultCodeEnum.SUCCESS.code().equals(code);
    }

    /**
     * 成功
     */
    public static <T> ApiResult<T> buildSuccess(ApiResultCodeEnum codeEnum, T data) {

        return build(codeEnum, data);
    }
    /**
     * 访问成功,返回业务错误
     */
    public static <T> ApiResult<T> buildSuccess(ApiResultCodeEnum codeEnum) {

        return build(codeEnum, null);
    }
    /**
     * 默认 SUCCESS
     */
    public static <T> ApiResult<T> buildSuccess(T data) {

        return buildSuccess(ApiResultCodeEnum.SUCCESS, data);
    }

    /**
     * 成功无数据返回
     */
    public static <T> ApiResult<T> buildSuccess() {

        return buildSuccess(ApiResultCodeEnum.SUCCESS);
    }

    /**
     * 失败
     */
    public static <T> ApiResult<T> buildFail(ApiResultCodeEnum codeEnum) {

        return build(codeEnum, null);
    }

    /**
     * 失败,默认SYSTEM_ERROR
     */
    public static <T> ApiResult<T> buildFail() {

        return build(ApiResultCodeEnum.FAIL, null);
    }

    public static <T> ApiResult<T> buildFail(String msg) {

        return build(ApiResultCodeEnum.FAIL.code(), msg, null);
    }

    public static <T> ApiResult<T> buildSystemFail(String msg) {
        return build(ApiResultCodeEnum.SYSTEM_ERROR.code(), msg, null);
    }


    /**
     * @description
     * @author yzMa
     * @date 2018/12/24 11:29 AM
     * @param
     * @return
     */
    public static <T> ApiResult<T> buildFail(String code,String msg,T data) {

        return build(code,msg,data);
    }

    /**
     * 功能描述: 其他codeEnum返回
     *
     * @param: [codeEnum, data]
     * @return: com.alipay.edu.campus.common.base.api.ApiResult<T>
     * @auther: zhz
     * @date: 18/8/22 上午9:58
     */
    public static <T> ApiResult<T> build(ApiResultCodeEnum codeEnum, T data) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(codeEnum.code());
        apiResult.setMessage(codeEnum.msg());
        apiResult.setData(data);
        apiResult.setTimestamp(System.currentTimeMillis());
        return apiResult;
    }

    /**
     * 功能描述: 特殊code-msg 返回
     *
     * @param: [code, msg, data]
     * @return: com.alipay.edu.campus.common.base.api.ApiResult<T>
     * @auther: zhz
     * @date: 18/8/22 上午9:59
     */
    public static <T> ApiResult<T> build(String code,String msg,T data){
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        apiResult.setData(data);
        apiResult.setTimestamp(System.currentTimeMillis());
        return apiResult;
    }

}
