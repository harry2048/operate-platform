package com.zr.approval.approvalEnum;

/**
 *(未使用)
 * 批扣渠道下拉框
 * Created by Administrator on 2019/6/22 0022.
 */
public enum ApprovalChannelMnum {
    TLZF("通联支付",0),YZF("翼支付",1);

    private String ApprovalChanneName;
    private Integer ApprovalChanneValue;

    //根据值获取名字
    public static String getApprovalChanneName(Integer apartmentValue){
        for(ApprovalChannelMnum approvalChannelMnum : ApprovalChannelMnum.values()){
            if(approvalChannelMnum.getApprovalChanneValue() == apartmentValue){
                return approvalChannelMnum.getApprovalChanneName();
            }
        }
        return null;
    }
    //根据名字获取值
    public static Integer getApprovalChanneValue(String apartmentName){
        for(ApprovalChannelMnum approvalChannelMnum : ApprovalChannelMnum.values()){
            if(approvalChannelMnum.getApprovalChanneName().equals(apartmentName)){
                return approvalChannelMnum.getApprovalChanneValue();
            }
        }
        return null;
    }












    ApprovalChannelMnum(String approvalChanneName, Integer approvalChanneValue) {
        ApprovalChanneName = approvalChanneName;
        ApprovalChanneValue = approvalChanneValue;
    }

    public String getApprovalChanneName() {
        return ApprovalChanneName;
    }

    public void setApprovalChanneName(String approvalChanneName) {
        ApprovalChanneName = approvalChanneName;
    }

    public Integer getApprovalChanneValue() {
        return ApprovalChanneValue;
    }

    public void setApprovalChanneValue(Integer approvalChanneValue) {
        ApprovalChanneValue = approvalChanneValue;
    }
}
