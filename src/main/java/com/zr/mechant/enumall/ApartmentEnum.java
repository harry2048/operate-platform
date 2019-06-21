package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum ApartmentEnum {
    JIZHONGSHI("集中式",0),FENSANSHI("分散式",1),JIZHONGFENSANSHI("集中/分散式",2);

    private String apartmentName;
    private Integer apartmentValue;

    public static String getApartmentName(Integer apartmentValue){
        for(ApartmentEnum apartmentEnum : ApartmentEnum.values()){
            if(apartmentEnum.getApartmentValue() == apartmentValue){
                return apartmentEnum.getApartmentName();
            }
        }
        return null;
    }

    public static Integer getApartmentValue(String apartmentName){
        for(ApartmentEnum apartmentEnum : ApartmentEnum.values()){
            if(apartmentEnum.getApartmentName().equals(apartmentName)){
                return apartmentEnum.getApartmentValue();
            }
        }
        return null;
    }

    ApartmentEnum(String apartmentName, Integer apartmentValue) {
        this.apartmentName = apartmentName;
        this.apartmentValue = apartmentValue;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public Integer getApartmentValue() {
        return apartmentValue;
    }

    public void setApartmentValue(Integer apartmentValue) {
        this.apartmentValue = apartmentValue;
    }
}
