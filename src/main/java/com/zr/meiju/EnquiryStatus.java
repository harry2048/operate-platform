package com.zr.meiju;

/**
 * Created by star on 2019/6/22.
 */
public enum EnquiryStatus {
    WEITUISONG("未推送",0),TUISONGCHENGGONG("推送成功",1),TUISONGSHIBAI("推送失败",2),DAITUISONG("待推送",3);
    private final String statusName;
    private final Integer statusValue;

    private EnquiryStatus(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (EnquiryStatus c : EnquiryStatus.values()) {
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

