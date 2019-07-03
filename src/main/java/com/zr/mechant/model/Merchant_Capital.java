package com.zr.mechant.model;

import lombok.Data;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Merchant_Capital {
    private Integer id;
    private Integer accountType;
    private String accountName;
    private  String openBank;
    private String bankAccount;
    private Integer advanceDays;
    private String oneRate;
    private String rate;
    private Integer mechantId;//外键

}
