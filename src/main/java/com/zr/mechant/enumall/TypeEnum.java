package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum TypeEnum {
    SHANGHU("商户",0),DAILI("代理",1);

    private String typeName;
    private Integer typeValue;

    public static String getTypeName(Integer typeValue){
        for(TypeEnum typeEnum : TypeEnum.values()){
            if(typeEnum.getTypeValue() == typeValue){
                return typeEnum.getTypeName();
            }
        }
        return null;
    }

    public static Integer getTypeValue(String typeName){
        for(TypeEnum typeEnum : TypeEnum.values()){
            if(typeEnum.getTypeName().equals(typeName)){
                return typeEnum.getTypeValue();
            }
        }
        return null;
    }

    TypeEnum(String typeName, Integer typeValue) {
        this.typeName = typeName;
        this.typeValue = typeValue;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(Integer typeValue) {
        this.typeValue = typeValue;
    }
}
