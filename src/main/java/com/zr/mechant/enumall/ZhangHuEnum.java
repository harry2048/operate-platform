package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum ZhangHuEnum {
    DUIGONG("对公",0),DUISI("对私",1);

    private String zhangHuName;
    private Integer zhangHuValue;

    public static String getZhangHuName(Integer zhangHuValue){
        for(ZhangHuEnum zhangHuEnum : ZhangHuEnum.values()){
            if(zhangHuEnum.getZhangHuValue() == zhangHuValue){
                return zhangHuEnum.getZhangHuName();
            }
        }
        return null;
    }

    public static Integer getZhangHuValue(String zhangHuName){
        for(ZhangHuEnum zhangHuEnum : ZhangHuEnum.values()){
            if(zhangHuEnum.getZhangHuName().equals(zhangHuName)){
                return zhangHuEnum.getZhangHuValue();
            }
        }
        return null;
    }

    ZhangHuEnum(String zhangHuName, Integer zhangHuValue) {
        this.zhangHuName = zhangHuName;
        this.zhangHuValue = zhangHuValue;
    }

    public String getZhangHuName() {
        return zhangHuName;
    }

    public void setZhangHuName(String zhangHuName) {
        this.zhangHuName = zhangHuName;
    }

    public Integer getZhangHuValue() {
        return zhangHuValue;
    }

    public void setZhangHuValue(Integer zhangHuValue) {
        this.zhangHuValue = zhangHuValue;
    }
}
