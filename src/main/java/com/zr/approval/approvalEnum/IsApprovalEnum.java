package com.zr.approval.approvalEnum;

/**
 * 是否可批扣下拉框
 * Created by Administrator on 2019/6/22 0022.
 */

public enum IsApprovalEnum {
    KPK("可批扣",0),BKPK("不可批扣",1);


    private String isApprovalName;
    private Integer isApprovalValue;


    //根据值获取名字
    public static String getisApprovalName(Integer apartmentValue){
        for(IsApprovalEnum isApprovalEnum : IsApprovalEnum.values()){
            if(isApprovalEnum.getIsApprovalValue() == apartmentValue){
                return isApprovalEnum.getIsApprovalName();
            }
        }
        return null;
    }
    //根据名字获取值
    public static Integer getisApprovalValue(String apartmentName){
        for(IsApprovalEnum isApprovalEnum : IsApprovalEnum.values()){
            if(isApprovalEnum.getIsApprovalName().equals(apartmentName)){
                return isApprovalEnum.getIsApprovalValue();
            }
        }
        return null;
    }








    IsApprovalEnum(String isApprovalName, Integer isApprovalValue) {
        this.isApprovalName = isApprovalName;
        this.isApprovalValue = isApprovalValue;
    }

    public String getIsApprovalName() {
        return isApprovalName;
    }

    public void setIsApprovalName(String isApprovalName) {
        this.isApprovalName = isApprovalName;
    }

    public Integer getIsApprovalValue() {
        return isApprovalValue;
    }

    public void setIsApprovalValue(Integer isApprovalValue) {
        this.isApprovalValue = isApprovalValue;
    }
}
