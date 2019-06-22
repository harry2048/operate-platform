package com.zr.pikouflowingwater.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity(name = "pikouflowingwater")
public class PiKouFlowingWater {
    @Id
    @GeneratedValue
    private Integer id;
    private String daiKouNum;
    private String daiKuanHetongNum;
    private String customerName;
    private String idCode;
    private Integer deductible;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date issuanceOfWithholdingTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date deductionTimeReceived;

    private Integer deductionStatus;//扣款状态
    @Transient
    private String deductionStatusName;



    private Integer deductionResults;// 扣款结果
    @Transient
    private String deductionResultsName;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String createName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private String updateName;

}
