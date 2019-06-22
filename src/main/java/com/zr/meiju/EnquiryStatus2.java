package com.zr.meiju;

/**
 * Created by star on 2019/6/22.
 */
public enum EnquiryStatus2 {
    SHENPIZHONG("审批中",0),TONGGUO("通过",1),
    YIDAHUI("已打回",2),YIQUXIAO("已取消",3),
    YIJUJUE("已拒绝",4),YIFANGKUAN("已放款",5),
    YIWNAJIE("已完结",6),TIQIANJIEQING("提前结清",7);

    private final String statusName;
    private final Integer statusValue;

    private EnquiryStatus2(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (EnquiryStatus2 c : EnquiryStatus2.values()) {
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

