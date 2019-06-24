package com.zr.sendrepaymentmessage.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class SendRepaymentMessage {
    private Integer id;

    private String orderNum;

    private String name;

    private String idCode;

    private Integer phone;

    private Integer numberOfPeriods;

    private Date deductionDate;

    private Date deliveryTime;

    private Integer sendingStatus;

    private String sendingStatusName;

    private Date createTime;

    private String createName;

    private Date updateTime;

    private String updateName;

}