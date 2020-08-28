package com.huayu.layuiUtils;


import com.huayu.pojo.UserClien;

import java.util.List;

public class Stulayui {
    private Integer code;
    private String msg;
    private Integer count;
    private List<UserClien> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserClien> getData() {
        return data;
    }

    public void setData(List<UserClien> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Stulayui{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
