package com.zr.jinjiansource.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class JinJianSourceSelectVo extends PageVo{
    private String customerName;// 客户姓名
    private String merchant;// 商户姓名

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTimeBegin;// 进件开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTimeOver;// 进件结束时间

}
