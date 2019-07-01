package com.zr.pikouflowingwater.enums;

import lombok.Getter;

@Getter
public enum  DeductionStatusEnum {
    WAIT(0, "待发送"),
    DEDUCTIONING(1, "扣款中"),
    DEDUCTSUCCESS(2, "代扣成功"),
    DEDUCTFAIL(3, "代扣失败"),
    SIGNING(4, "JD签约中"),
    SIGNFAIL(5, "JD签约失败"),
    SIGNSUCCESS(6, "JD签约成功"),
    REPAYMENTSUCCESS(7, "还款成功"),

    ;
    private Integer code;
    private String msg;

    DeductionStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(Integer code) {
        for (DeductionStatusEnum d : DeductionStatusEnum.values()) {
            if (d.code == code) {
                return d.msg;
            }
        }
        return null;
    }
    public static Integer getCode(String msg) {
        for (DeductionStatusEnum d : DeductionStatusEnum.values()) {
            if (d.msg.equals(msg)) {
                return d.code;
            }
        }
        return null;
    }
}
