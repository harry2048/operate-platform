package com.zr.earliersettlement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/21.
 */
@Data
public class EarliersettlementSelectVo extends PageVo{
    private Date settleTime; //datetime DEFAULT NULL COMMENT '结清日期',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date settleTimeStart; //datetime DEFAULT NULL COMMENT '结清日期开始',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date settleTimeEnd; //datetime DEFAULT NULL COMMENT '结清日期结束',

    private Date loanTime; //datetime DEFAULT NULL COMMENT '放款日期',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date loanTimeStart; //datetime DEFAULT NULL COMMENT '放款日期开始',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date loanTimeEnd; //datetime DEFAULT NULL COMMENT '放款日期结束',

    private String  businessType;// varchar(20) DEFAULT NULL COMMENT '业务类型',

    private String  orderNum; //varchar(20) DEFAULT NULL COMMENT '订单编号',

    private String  managemen; //varchar(200) DEFAULT NULL COMMENT '资方',

    private Integer channel;// int(10) DEFAULT NULL COMMENT '渠道',

    private String channelName;// int(10) DEFAULT NULL COMMENT '渠道名称',

    private String  customerName; //varchar(100) DEFAULT NULL COMMENT '客户姓名',

    private String  idCode; //varchar(20) DEFAULT NULL COMMENT '身份证号码',

    private Boolean status;

    private String phone;

}
