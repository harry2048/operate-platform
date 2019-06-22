package com.zr.pikouflowingwater.enums;

import lombok.Getter;

/**
 * 扣款结果枚举
 */
@Getter
public enum  DeductionResultsEnum {
    success(1, "微信支付成功"),
    ;
    private Integer code;
    private String msg;

    DeductionResultsEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(Integer code) {
        for (DeductionResultsEnum d : DeductionResultsEnum.values()) {
            if (d.code == code) {
                return d.msg;
            }
        }
        return null;
    }
    public static Integer getCode(String msg) {
        for (DeductionResultsEnum d : DeductionResultsEnum.values()) {
            if (d.msg.equals(msg)) {
                return d.code;
            }
        }
        return null;
    }
}
