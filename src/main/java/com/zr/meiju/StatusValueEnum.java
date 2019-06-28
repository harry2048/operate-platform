package com.zr.meiju;

/**
 * Created by 86151 on 2019/4/25.
 */
public enum StatusValueEnum {
    QIYONG(1),JINYONG(0);

    private final Integer status;

    private StatusValueEnum(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
