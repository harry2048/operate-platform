package com.zr.mechant.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum HouseEnum {
    YUNXU("允许",0),BUYUNXU("不允许",1);

    private String houseName;
    private Integer houseValue;

    public static String getHouseName(Integer houseValue){
        for(HouseEnum houseEnum : HouseEnum.values()){
            if(houseEnum.getHouseValue() == houseValue){
                return houseEnum.getHouseName();
            }
        }
        return null;
    }

    public static Integer getHouseValue(String houseName){
        for(HouseEnum houseEnum : HouseEnum.values()){
            if(houseEnum.getHouseName().equals(houseName)){
                return houseEnum.getHouseValue();
            }
        }
        return null;
    }

    HouseEnum(String houseName, Integer houseValue) {
        this.houseName = houseName;
        this.houseValue = houseValue;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getHouseValue() {
        return houseValue;
    }

    public void setHouseValue(Integer houseValue) {
        this.houseValue = houseValue;
    }
}
