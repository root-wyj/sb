package com.wyj.alipay.springboot.sbbase;


import java.util.Date;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/27
 */

public class Business {

    private Integer id;

    private String type_code;

    private String type_name;

    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Business[id:"+ id +", type_name:"+type_name+", create_time:"+create_time+"]";
    }

}
