package com.zr.loansituation.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

/**
 * Created by star on 2019/6/22.
 */
@Data
public class LoansituationSelectVo extends PageVo {

//    private  Integer id;

    private String idCode;      //身份证号码

    private String customerName;   //客户姓名
    private Integer contactNumber;//联系电话

    private String merchant;    //商户

 /*   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Data incomingPartsTime; //进件时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Data incomingPartsTimeStart; //进件时间(开始)

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Data incomingPartsTimeEnd; //进件时间(结束)

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Data letterTrialTime;  //信审日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Data letterTrialTimeStart;  //信审日期(开始)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Data letterTrialTimeEnd;  //信审日期(结束)

    private String managementNum;   //资方申请编号

    private Integer incomingPartsChannel;   //进件渠道




    private  Integer term;  //期限

    private Data approvalTime;  //审批时间


    private  Data createTime;   //创建时间

    private  String createName;

    private Data updateTime;

    private String updateName;*/




}
