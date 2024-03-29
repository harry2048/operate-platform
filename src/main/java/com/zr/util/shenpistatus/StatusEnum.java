package com.zr.util.shenpistatus;

import lombok.Getter;

@Getter
public enum StatusEnum {
    ZHENGCHANG("正常状态",0),
    QUEDING("确定状态",1),
    QUXIAO("取消状态",2),
    SHENGHETONGGUO("审核通过",3),
    SHENHEBUTONGGUO("审核不通过状态",4),
    ZUOFEI("作废",5)
    ;

    private String statusName;
    private Integer statusValue;
    // 通过值取名称
    public static String getName(int relationsWithMeValue) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getStatusValue() == relationsWithMeValue) {
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

    StatusEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }

}