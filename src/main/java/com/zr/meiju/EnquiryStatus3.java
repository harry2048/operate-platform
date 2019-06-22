package com.zr.meiju;

/**
 * Created by star on 2019/6/22.
 */
public enum EnquiryStatus3 {
    WEITUISONG("未签章",0),TUISONGCHENGGONG("已签章",1);
    private final String statusName;
    private final Integer statusValue;

    private EnquiryStatus3(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (EnquiryStatus3 c : EnquiryStatus3.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
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

