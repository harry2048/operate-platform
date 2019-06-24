package com.zr.jiuyitobelent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/4.
 */
@Data
public class JiuYiToBelent {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Date applyTime;//申请时间
    private String  channel;//渠道
    private Double amountOfApplication;//申请金额
    private Integer applicationDeadline;//申请期限
    private Double periodicContributions;//期供款
    private String customerName;//客户姓名
    private String idCode;//证件号
    private Double managementLoanAmount;//资方放款金额
    private Integer managementStatus;//资方状态
    private String managementStatusName;//资方状态名称
    private  Date createTime;//创建日期
    private String createName;//创建人
    private  Date updateTime;//修改日期
    private String updateName;//修改人
}
