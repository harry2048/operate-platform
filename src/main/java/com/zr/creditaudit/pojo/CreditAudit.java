package com.zr.creditaudit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity(name = "creditaudit")
public class CreditAudit {
    @Id
    @GeneratedValue
    private Integer id;
    private String auditPersonName;
    private Integer auditSum;

    private Integer auditPassNum;
    private Double auditPassRat;

    private Integer auditFailNum;
    private Double auditFailRat;

    private Integer caseRefuseNum;
    private Double caseRefuseRat;

    private Integer caseCancelNum;
    private Double caseCancelRat;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String createName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private String updateName;

}
