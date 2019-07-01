package com.zr.returnhandling.model;

import lombok.Data;
//退货处理实体类
@Data
public class ReturnHandlingVo {
    //商户ID
    private Integer id;
    //商户
    private String merchant;
    //客户名称
    private String customerName;
    //退款金额
    private Integer refundAmount;
//    //审核状态
   private Integer sendingStatus;
    //审核状态名称
    private String sendingStatusName;
    //申请日期==生成日期
    private String createTime;
    //审核日期
    private String examineTime;
//    //申请人
//    private String createName;
//    //处理人
//    private String updateName;
//    //处理日期==退货日期
//    private String updateTime;
    //外键
//    private int uid;

    //用户的名称
//    private String names;

}





