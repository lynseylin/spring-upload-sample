package com.fox.web.domain;

/**
 * Created by linxiaofang on 2017/8/30.
 */
public enum ResultEnum {
    SUCCESS(200, "success"),
    // 600以上是自定义的错误
    ERROR(601, "upload error"),
    PARAMETERS_ERROR(602, "parameter error");

    private int code;
    private String desc;

    ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
