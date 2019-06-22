package com.zr.creditaudit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class CreditAuditSelectVo extends PageVo{

    private String auditPersonName;// 信审员姓名


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTimeBegin;//信审开始日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTimeOver;//信审结束日期


    public CreditAuditSelectVo() {
    }

    public CreditAuditSelectVo(String auditPersonName, Date createTimeBegin, Date createTimeOver) {
        this.auditPersonName = auditPersonName;
        this.createTimeBegin = createTimeBegin;
        this.createTimeOver = createTimeOver;
    }
}
