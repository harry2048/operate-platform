package com.zr.approval.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
@Entity(name = "approval")
public class Approval extends PageVo{
    @Id     //主键
    @GeneratedValue//自增
    private  Integer id;
    private  Integer  status;//批扣状态
    private String approvalChannel;//批扣渠道
    private Integer isApproval;//是否可批扣
    private String loanContractNum;//贷款合同号
    private String customerName;//客户姓名
    private String idCode;//证件号
    private double deductible;//应扣款
    private String reimbursementAccountOpeningBank;//还款账户开户行
    private Integer paymentAccount;//还款账号
    private String deductionResults;//扣款结果
    private Date createTime;    //创建时间
    private String createName;  //创建人
    private Date updateTime;    //修改时间
    private String updateName;  //修改人


}
