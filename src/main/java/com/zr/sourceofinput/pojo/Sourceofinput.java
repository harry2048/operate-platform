package com.zr.sourceofinput.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@Data
@Entity(name = "sourceofinput")
public class Sourceofinput {
    @Id
    @GeneratedValue
    private Integer id;
    private String merchant;//'商户
    private String customerName;//客户姓名
    private String orderNum;//订单编号
    private Integer idCode;//身份证号码
    private Date incomingPartsTime;//进件时间
    private String incomingPartsProvince;//进件省份
    private String incomingPartsCity;//进件城市
    private String specificAddress;//具体地址
    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;
}
