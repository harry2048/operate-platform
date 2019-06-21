package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum StatusEnum {
    WEIQIYONG("未启用",0),YIQIYONG("已启用",1),YIDAOQI("已到期",2);

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

    StatusEnum(String statusName, Integer statusValue) {
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
