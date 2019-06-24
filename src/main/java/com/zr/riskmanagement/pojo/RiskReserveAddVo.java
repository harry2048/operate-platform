package com.zr.riskmanagement.pojo;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskReserveAddVo {//基本信息表

    private double riskReserve;//风险准备金
    private double lineCredit;//授信额度
    private String reserveCoefficient;//风险准备金系数
    @NotNull(message = "商户ID不能为空")
    private Integer  remeId;//商户ID

    private String capitalSide;//资金方

    private String pic;//资料图片
}
