package com.zr.loansituation.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by star on 2019/6/22.
 */
@Data
public class LoansituationSelectVo extends PageVo {

//    private  Integer id;
    private String idCode;      //身份证号码

    private String customerName;   //客户姓名
    private Integer contactNumber;//联系电话

   private Integer loanFishStatus; //贷鱼状态
    private Integer pushStatus; //推送状态
    private Integer signatureStatus;    //签章状态

    private String merchant;    //商户


   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTime; //进件时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTimeStart; //进件时间(开始)

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTimeEnd; //进件时间(结束)


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date letterTrialTime;  //信审日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Date letterTrialTimeStart;  //信审日期(开始)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Date letterTrialTimeEnd;  //信审日期(结束)


    private String managementNum;   //资方申请编号

    private Integer incomingPartsChannel;   //进件渠道

    private  Integer term;  //期限
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date approvalTime;  //审批时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Date createTime;   //创建时间

    private  String createName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;

    private String updateName;

}
