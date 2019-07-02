package com.zr.returnhandling.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class ReturnHandlingSelectVo extends PageVo {

    //商户名称
    private String merchant;
    //客户名称
    private String customerName;
    //审核状态
    private Integer sendingStatus;
    private String  sendingStatusName;
    //申请日期==生成日期
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date  createTime;
    //处理日期==退货日期
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private Integer value;

}
