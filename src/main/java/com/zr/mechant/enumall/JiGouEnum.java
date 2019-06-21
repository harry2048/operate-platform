package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum JiGouEnum {
    JIGOU("机构",0),ZIJIN("资金",1);

    private String jiGouName;
    private Integer jiGouValue;

    public static String getJiGouName(Integer jiGouValue){
        for(JiGouEnum jiGouEnum : JiGouEnum.values()){
            if(jiGouEnum.getJiGouValue() == jiGouValue ){
                return jiGouEnum.getJiGouName();
            }
        }
        return null;
    }

    public static Integer getJiGouValue(String jiGouName){
        for(JiGouEnum jiGouEnum : JiGouEnum.values()){
            if(jiGouEnum.getJiGouName().equals(jiGouName)){
                return jiGouEnum.getJiGouValue();
            }
        }
        return null;
    }

    JiGouEnum(String jiGouName, Integer jiGouValue) {
        this.jiGouName = jiGouName;
        this.jiGouValue = jiGouValue;
    }

    public String getJiGouName() {
        return jiGouName;
    }

    public void setJiGouName(String jiGouName) {
        this.jiGouName = jiGouName;
    }

    public Integer getJiGouValue() {
        return jiGouValue;
    }

    public void setJiGouValue(Integer jiGouValue) {
        this.jiGouValue = jiGouValue;
    }
}
