package com.zr.mechant.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_Generatinginformation {
    private Integer id;
    private Integer bankCard;
    private String affiliatedBank;
    private String mailbox;
    private String province;
    private String jointLineNumber;
    private String lenderName;
    private  String lenderAddress;
    private  Integer lenderPhone;
    private  String  bankCity;

    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;
    private Integer mechantId;//外键


}
