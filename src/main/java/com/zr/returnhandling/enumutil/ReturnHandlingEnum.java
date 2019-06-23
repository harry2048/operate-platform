package com.zr.returnhandling.enumutil;

import lombok.Getter;

@Getter
public enum ReturnHandlingEnum {
    DAITIJIAO("待提交",0),DAISHENPI("待审批",1),
    DAICAIWUSHENPI("待财务审批",2),
    YIJUJUE("已拒绝",3),CAIWUTONGGUO("财务通过",4),
    CAIWUJUJUE("财务拒绝",5);

    private final String sendingStatusName;
    private final Integer sendingStatusValue;

    ReturnHandlingEnum(String sendingStatusName, Integer sendingStatusValue)
    {
        this.sendingStatusName = sendingStatusName;
        this.sendingStatusValue = sendingStatusValue;
    }

}