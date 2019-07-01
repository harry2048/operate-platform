package com.zr.xinshenstatistics.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by jiangping on 2019/6/21.
 */
@Data
public class Xinshenstatistics {

    private Integer id;//
    private String auditors;//'审核人员'
    private String channel;//'渠道'
    private Integer managemen;//'资方'
    private Integer scopeOfBusiness;//'业务范围'
    private String orderNum;//'订单编号'
    private Integer status;//'状态'
    private Date applyTime;//'申请时间'
    private Date chuShenTime;//'初审时间'
    private Date fuShenTime;//'复审时间'
    private Date approvalTime;//'审批历时'
    private String storeName;//'门店名称
    private String customerName;//'客户姓名'
    private String idCode;//'身份证号码'
    private Integer phone;//'客户手机号'
    private Date loanTime;//'放款日期'
    private Double applicationAmount;//'申请金额'
    private Double loanBalance;//'贷款余额'
    private Double periodicContributions;//'期供款'
    private Integer applicationDeadline;//'申请期限'
    private Double overdueAmount;//'逾期金额'
    private Integer overdueNum;//'逾期天数'
    private Date createTime;//'创建时间'
    private String createName;//
    private Date updateTime;//
    private String updateName;//


}
