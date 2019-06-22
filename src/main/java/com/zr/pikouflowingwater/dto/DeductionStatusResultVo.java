package com.zr.pikouflowingwater.dto;

import lombok.Data;

@Data
public class DeductionStatusResultVo {
    private Integer label;
    private String value;

    public DeductionStatusResultVo() {
    }

    public DeductionStatusResultVo(Integer label, String value) {
        this.label = label;
        this.value = value;
    }
}
