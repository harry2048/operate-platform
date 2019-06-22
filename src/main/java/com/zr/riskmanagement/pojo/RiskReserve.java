package com.zr.riskmanagement.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskReserve {//基本信息表

    private Integer id;
    private double riskReserve;//风险准备金
    private double lineCredit;//授信额度
    private String reserveCoefficient;//风险准备金系数
    private Integer  remeId;//商户Id
}
