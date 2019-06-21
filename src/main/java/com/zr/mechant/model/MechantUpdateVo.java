package com.zr.mechant.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class MechantUpdateVo {
    private  Integer id;
    private  String  merchantName;
    private String merchantLegalPerson;
    private String merchantAddress;
    //@NotBlank(message = "商户名称不能为空")
    private String merchantDesc;
    private Integer foreignPhone;
    private Integer phone;

    private Integer bankCard;
    private String affiliatedBank;
    private String mailbox;
    private String province;
    private String jointLineNumber;
    private String accountName;
    private  String lenderAddress;
    private  Integer lenderPhone;
    private  String  bankCity;

    private String management;
    private String remark;
    private Integer status;
    private String  code;
    private Integer mechant_id;

    private Date startTime  ;
    private Date  endTime;

    private  String landingAccount;
    private String landingPassword;
    private  Integer type;
    private Integer isStore;
    private Integer isCreateStore;
    private Integer  isDeduction;
    private  Integer isGrantAuthorization;
    private Integer isActiveRepayment;
    private Integer education;
    private Integer renting;
    private Integer digital;
    private Integer blueWaterSource;
    private Integer huaBei;
    private Integer medicalBeauty;
    private Integer  channelMaintenance;
    private  Integer apartmentType;
    private Integer isAddHousingResources;
    private  Integer mechanismType;

    private Integer accountType;
    //private String accountName;
    private  String openBank;
    private String bankAccount;
    private Integer advanceDays;
    private String oneRate;
    private String rate;

    private String  zhifubaoAccount;
    private String zhifubaoPid;

    private String pic;

    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;

}
