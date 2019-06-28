package com.zr.daifangkuan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:34
 */
@Data
@Entity(name="daifangkuan")
public class DaiFangKuanEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer status;//资方状态',
    private String  name;//姓名',
    private Integer phone;//手机号',
    private String  merchant;//商户',
    private Integer oldNumber;//订单编号',
    private Integer channel;//'渠道',
    private Integer applyAmount;//'申请金额',
    private Integer applyTerm;//'申请期限',
    private Integer periodicContributions;//'期供款',
    private String  idCode;//'身份证号码',
    private Double  managementLoanAmount;//'资方放款金额',
    private Double  InteractionLoanAmount;//'互动放款金额',
    private Date   createTime;//'申请时间',
    private String  createName;//DEFAULT NULL,
    private Date updateTime;
    private String  updateName;
    @Transient
    private String statusName;//资方状态
    @Transient
    private String operation;


}
