package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum KouKuanEnum {
    HUDONGKOUKUAN("互动扣款",0),ZIFANGKOUKUAN("资方扣款",1),SHANGHUKOUKUAN("商户扣款",2);

    private String kouKuanName;
    private Integer kouKuanValue;

    public static String getKouKuanName(Integer  kouKuanValue){
        for(KouKuanEnum kouKuanEnum : KouKuanEnum.values()){
            if(kouKuanEnum.getKouKuanValue() ==  kouKuanValue){
                return kouKuanEnum.getKouKuanName();
            }
        }
        return null;
    }

    public static Integer getKouKuanValue(String kouKuanName){
        for(KouKuanEnum kouKuanEnum : KouKuanEnum.values()){
            if(kouKuanEnum.getKouKuanName().equals(kouKuanName)){
                return kouKuanEnum.getKouKuanValue();
            }
        }
        return null;
    }

    KouKuanEnum(String kouKuanName, Integer kouKuanValue) {
        this.kouKuanName = kouKuanName;
        this.kouKuanValue = kouKuanValue;
    }

    public String getKouKuanName() {
        return kouKuanName;
    }

    public void setKouKuanName(String kouKuanName) {
        this.kouKuanName = kouKuanName;
    }

    public Integer getKouKuanValue() {
        return kouKuanValue;
    }

    public void setKouKuanValue(Integer kouKuanValue) {
        this.kouKuanValue = kouKuanValue;
    }
}
