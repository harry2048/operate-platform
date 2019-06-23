package com.zr.jinjiansource.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JinJianSourceOutputVo {
    private String merchant;
    private String customerName;
    private String orderNum;
    private String idCode;
    private Date incomingPartsTime;
    private String incomingPartsProvince;
    private String incomingPartsCity;
    private String specificAddress;

    public JinJianSourceOutputVo() {
    }

    public JinJianSourceOutputVo(String merchant, String customerName, String orderNum, String idCode, Date incomingPartsTime, String incomingPartsProvince, String incomingPartsCity, String specificAddress) {
        this.merchant = merchant;
        this.customerName = customerName;
        this.orderNum = orderNum;
        this.idCode = idCode;
        this.incomingPartsTime = incomingPartsTime;
        this.incomingPartsProvince = incomingPartsProvince;
        this.incomingPartsCity = incomingPartsCity;
        this.specificAddress = specificAddress;
    }
}
