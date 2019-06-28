package com.zr.meiju;

/**
 * Created by 86151 on 2019/4/25.
 */
public enum StatusZhongWenEnum {
    QIYONG("启用"),JINYONG("禁用");

    private final String status;

    private StatusZhongWenEnum(String status)
    {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
