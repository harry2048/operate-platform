package com.zr.creditaudit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CreditAuditResultVo {
    private Integer id;
    private String auditPersonName;
    private Integer auditSum;

    private Integer auditPassNum;
    //private Double auditPassRat;
    private String auditPassRats;


    private Integer auditFailNum;
    //private Double auditFailRat;
    private String auditFailRats;

    private Integer caseRefuseNum;
    //private Double caseRefuseRat;
    private String caseRefuseRats;

    private Integer caseCancelNum;
    //private Double caseCancelRat;
    private String caseCancelRats;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String createName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private String updateName;
}
