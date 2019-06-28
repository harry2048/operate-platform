package com.zr.approval.approvalEnum;

/**
 * 批扣状态下拉框
 * Created by Administrator on 2019/6/22 0022.
 */
public enum StatusEnmu {

    SCQD("生成清单",0),DZCFS("待再次发送",1),KKZ("扣款中",2),DKCG("代扣成功",3),DKSB("代扣失败",4),JDQYZ("JD签约中",5),JDQYCG("JD签约成功",6),
    JDQYSB("JD签约失败",7),SCDDCG("微信预生成订单成功",8),SCDDSB("微信预生成订单失败",9),WXZFSB("微信支付失败",10);

    private String statusName;
    private Integer StatusValue;


    //根据值获取名字
    public static String getstatusName(Integer apartmentValue){
        for(StatusEnmu statusEnmutatusEnmu : StatusEnmu.values()){
            if(statusEnmutatusEnmu.getStatusValue() == apartmentValue){
                return statusEnmutatusEnmu.getStatusName();
            }
        }
        return null;
    }
    //根据名字获取值
    public static Integer getstatusValue(String apartmentName){
        for(StatusEnmu statusEnmutatusEnmu : StatusEnmu.values()){
            if(statusEnmutatusEnmu.getStatusName().equals(apartmentName)){
                return statusEnmutatusEnmu.getStatusValue();
            }
        }
        return null;
    }








    //要有构造器否则上面会报错
    StatusEnmu(String statusName, Integer statusValue) {
        this.statusName = statusName;
        StatusValue = statusValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getStatusValue() {
        return StatusValue;
    }

    public void setStatusValue(Integer statusValue) {
        StatusValue = statusValue;
    }
}
