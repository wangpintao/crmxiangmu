package com.huayu.JsonUtils;

public class StulayuiJson {
    private Integer code;// 1代表成功 2代表失败 3代表其他异常
    private String msg;//异常信息
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
