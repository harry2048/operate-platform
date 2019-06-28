package com.zr.earliersettlement.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/21.
 */
@Data
public class Earliersettlement {
    private Integer id;
    private String  businessType;// varchar(20) DEFAULT NULL COMMENT '业务类型',
    private String  orderNum; //varchar(20) DEFAULT NULL COMMENT '订单编号',
    private Date settleTime; //datetime DEFAULT NULL COMMENT '结清日期',
    private Date loanTime; //datetime DEFAULT NULL COMMENT '放款日期',
    private String  managemen; //varchar(200) DEFAULT NULL COMMENT '资方',
    private Integer channel;// int(10) DEFAULT NULL COMMENT '渠道',
    private String  customerName; //varchar(100) DEFAULT NULL COMMENT '客户姓名',
    private String  idCode; //varchar(20) DEFAULT NULL COMMENT '身份证号码',
    private Double shenQingAmount; //double(20,2) DEFAULT NULL COMMENT '申请金额',
    private Double shenQingNum; //double(20,2) DEFAULT NULL COMMENT '申请期数',
    private Double qiGongKuan; //double(20,2) DEFAULT NULL COMMENT '期供款',
    private Double surplusNum; //double(20,2) DEFAULT NULL COMMENT '剩余期数',
    private Double yiHuanAmount; //double(20,2) DEFAULT NULL COMMENT '已还款金额',
    private Double zhinaAmount; //double(20,2) DEFAULT NULL COMMENT '滞纳金',
    private String  penaltyInterest;//varchar(20) DEFAULT NULL COMMENT '罚息',
    private String  compoundInterest; //varchar(20) DEFAULT NULL COMMENT '复利',
    private Double yuQiAmount; //double(20,2) DEFAULT NULL COMMENT '逾期管理费',
    private Integer yuQiDay; //int(20) DEFAULT NULL COMMENT '逾期天数',
    private Double yuQiPeriods; //double(20,2) DEFAULT NULL COMMENT '逾期期数',
    private Double amountOfRefund; //interest double(20,2) DEFAULT NULL COMMENT '退贴息金额',
    private Double interestRate; //double(20,2) DEFAULT NULL COMMENT '利率',
    private Double merchantTuiDaiYuAmount; //double(20,2) DEFAULT NULL COMMENT '商户应退贷鱼金额',
    private Double daiYuTuiZiFangAmount; //double(20,2) DEFAULT NULL COMMENT '贷鱼应退资方金额',
    private Double managemenLoanAmount; //double(20,2) DEFAULT NULL COMMENT '资方放款金额',
    private Double DaiYuLoanAmount; //double(20,2) DEFAULT NULL COMMENT '贷鱼放款金额',
    private Boolean status; //int(20) DEFAULT NULL COMMENT '状态',
    private String statusName; //int(20) DEFAULT NULL COMMENT '状态',

    private Date createTime; //datetime DEFAULT NULL COMMENT '创建时间',
    private String  createName; //varchar(20) DEFAULT NULL,
    private Date updateTime; //datetime DEFAULT NULL,
    private String  updateName; //varchar(20) DEFAULT NULL,
    private String phone;
}
