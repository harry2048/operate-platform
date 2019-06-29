package com.zr.jiuyitobelent.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum ManagementStatusEnum {
    YIFANGKUAN("已放款",0),YIJUJUE("已拒绝",1),DAKUANSHIBAI("打款失败",2);

    private String managementStatusName;
    private Integer managementStatusValue;

    public static String getManagementStatusName(Integer managementStatusValue){
        for(ManagementStatusEnum managementStatusEnum : ManagementStatusEnum.values()){
            if(managementStatusEnum.getManagementStatusValue() == managementStatusValue){
                return managementStatusEnum.getManagementStatusName();
            }
        }
        return null;
    }

    public static Integer getManagementStatusValue(String managementStatusName){
        for(ManagementStatusEnum managementStatusEnum : ManagementStatusEnum.values()){
            if(managementStatusEnum.getManagementStatusName().equals(managementStatusName)){
                return managementStatusEnum.getManagementStatusValue();
            }
        }
        return null;
    }

    ManagementStatusEnum(String managementStatusName, Integer managementStatusValue) {
        this.managementStatusName = managementStatusName;
        this.managementStatusValue = managementStatusValue;
    }

    public String getManagementStatusName() {
        return managementStatusName;
    }

    public void setManagementStatusName(String managementStatusName) {
        this.managementStatusName = managementStatusName;
    }

    public Integer getManagementStatusValue() {
        return managementStatusValue;
    }

    public void setManagementStatusValue(Integer managementStatusValue) {
        this.managementStatusValue = managementStatusValue;
    }
}
