package com.zr.riskmanagement.pojo;

import lombok.Data;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskReserveZiliao {//资料表
    private Integer id;
    private String pic;//资料图片
    private Integer riskReserveId;//基本信息表外键
}
