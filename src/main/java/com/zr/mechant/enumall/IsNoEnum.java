package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum IsNoEnum {
    SHI("否",0),FOU("是",1);

    private String isNoName;
    private Integer isNoValue;

    public static String getIsNoName(Integer isNoValue){
        for(IsNoEnum isNoEnum : IsNoEnum.values()){
            if(isNoEnum.getIsNoValue() == isNoValue){
                return isNoEnum.getIsNoName();
            }
        }
        return null;
    }

    public static Integer getIsNoValue(String isNoName){
        for(IsNoEnum isNoEnum : IsNoEnum.values()){
            if(isNoEnum.getIsNoName().equals(isNoName)){
                return isNoEnum.getIsNoValue();
            }
        }
        return null;
    }

    IsNoEnum(String isNoName, Integer isNoValue) {
        this.isNoName = isNoName;
        this.isNoValue = isNoValue;
    }

    public String getIsNoName() {
        return isNoName;
    }

    public void setIsNoName(String isNoName) {
        this.isNoName = isNoName;
    }

    public Integer getIsNoValue() {
        return isNoValue;
    }

    public void setIsNoValue(Integer isNoValue) {
        this.isNoValue = isNoValue;
    }
}
