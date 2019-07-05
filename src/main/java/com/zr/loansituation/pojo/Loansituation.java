package com.zr.loansituation.pojo;

import lombok.Data;
import org.springframework.cglib.core.TinyBitSet;

import java.util.Date;

/**
 * Created by star on 2019/6/21.
 */
@Data
public class Loansituation {

    private  Integer id;

    private String merchant;    //商户

    private String customerName;   //客户姓名

    private String idCode;      //身份证号码

    private Double amount;      //金额

    private Date incomingPartsTime; //进件时间

    private  Integer term;  //期限

    private Date approvalTime;  //审批时间

    private String managementNum;   //资方申请编号

    private Integer loanFishStatus; //贷鱼状态

    private Integer contactNumber;  //联系电话

    private Integer management; //资方

    private Integer pushStatus; //推送状态

    private String pushStatusName; //推送状态名称


    private Integer incomingPartsChannel;   //进件渠道

    private Integer signatureStatus;    //签章状态

    private  Date createTime;   //创建时间

    private  Date letterTrialTime;  //信审日期

    private  String createName;

    private Date updateTime;

    private String updateName;




}
