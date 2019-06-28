package com.zr.util;

import com.zr.mechant.enumall.StatusEnum;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 18:25
 * 已放款，已拒绝，打款失败
 */
public enum DFKStatusEnum {
    YIFANGKUAN("已放款",0),YIJUJUE("已拒绝",1),DAKUANSHIBAI("打款失败",2);

    private String statusName;
    private Integer statusValue;

    public static String getStatusName(Integer statusValue){
        for(StatusEnum statusEnum : StatusEnum.values()){
            if(statusEnum.getStatusValue() == statusValue){
                return statusEnum.getStatusName();
            }
        }
        return null;
    }

    public static Integer getStatusValue(String statusName){
        for(StatusEnum statusEnum : StatusEnum.values()){
            if(statusEnum.getStatusName().equals(statusName)){
                return statusEnum.getStatusValue();
            }
        }
        return null;
    }

    DFKStatusEnum(String statusName, Integer statusValue) {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(Integer statusValue) {
        this.statusValue = statusValue;
    }

}
