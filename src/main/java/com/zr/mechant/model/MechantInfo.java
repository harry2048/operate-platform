package com.zr.mechant.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/4.
 */
@Data
public class MechantInfo  {
    private Integer id;
    private  String merchantName;//商户名称
    private String  merchantAddress;//商户地址
    private Integer maintenanceChannel;//维护渠道
    //private 业务类型
    private Date startTime;
    private Date endTime;
    private Integer status;
    private String statusName;
    private Integer mechantId;//外键

}
