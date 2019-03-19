package com.wyj.alipay.springboot.common.base.enums;

/**
 * Created
 * Author: wyj
 * Date: 2019/1/8
 */
public enum ApiResultCodeEnum {
    /** 000  系统级别 */
    SUCCESS("000001", "成功"),
    FAIL("000010","操作失败，请联系管理员"),
    SYSTEM_ERROR("000002", "系统异常"),
    PARAM_INVALID("000003", "参数异常"),
    THIRD_TIMEOUT("000004", "调用合作方服务超时,请稍后重试"),
    FEIGN_TIMEOUT("000005","调用微服务超时"),
    // 上传文件不能为空
    FILE_NULL("000006", "上传文件不能为空"),
    FILE_ERROR("000007", "上传文件出错"),
    FILE_FAIL("000008", "图片不符合要求,请重新上传"),
    FILE_SUFFX_ERROR("000009","上传文件必须以jpg和gif结尾的图片"),

    TIMEOUT_HYSTRIX("000008", "服务请求超时熔断"),


    AUTH_INVALID("100001", "未授权"),

    ;

    private String code;
    private String msg;
    ApiResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public String code() {
        return code;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     *
     * @return the enum
     */
    public static ApiResultCodeEnum getEnum(String code) {
        for (ApiResultCodeEnum ele : ApiResultCodeEnum.values()) {
            if (ele.code().equals(code)) {
                return ele;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ApiResultCodeEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
