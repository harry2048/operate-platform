package com.zr.meiju;

/**
 * Created by 86151 on 2019/4/25.
 */

public enum BusinessTypeEnum {
    JIAOYU("教育",0),
    ZUFANG("租房",1),
    SHUMA("数码",2),
    BISHUIYUAN("碧水源",3);

    private final String statusName;
    private final Integer statusValue;

    private BusinessTypeEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (BusinessTypeEnum c : BusinessTypeEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (BusinessTypeEnum c : BusinessTypeEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
//    public String getStatusName() {
//        return statusName;
//    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }
}
