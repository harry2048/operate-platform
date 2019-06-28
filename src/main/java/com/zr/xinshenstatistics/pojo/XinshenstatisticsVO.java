package com.zr.xinshenstatistics.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.xinshenstatistics.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by jiangping on 2019/6/21.
 */
@Data
public class XinshenstatisticsVO extends PageVo{
    private Integer id;//
    private String orderNum;//'订单编号'
    private Integer status;//'状态'
    private Date applyTime;//'申请时间'
    private Date chuShenTime;//'初审时间'
    private Date fuShenTime;//'复审时间'
    private Date approvalTime;//'审批历时'
    private String storeName;//'门店名称
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











    private String customerName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date startTime;//'创建时间'
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date endTime;//
    private String Auditors;//'审核人员'
    private Integer channel;//'渠道'
    private String managemen;//'资方'
    private String scopeOfBusiness;//'业务范围'
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date startloanTime;//'放款日期'
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date endloanTime;//'放款日期'
}
