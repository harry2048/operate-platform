package com.zr.sendrepaymentmessage.util;

/**
 * Created by 86151 on 2019/4/25.
 */

public enum StatusEnum {
    JINYONG("未发送",0),QIYONG("已发送",1);

    private final String statusName;
    private final Integer statusValue;

    private StatusEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 通过值取名称
    public static String getName(int statusValue) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }


    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }
}
