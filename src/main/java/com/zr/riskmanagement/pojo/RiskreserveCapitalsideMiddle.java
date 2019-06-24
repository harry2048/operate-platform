package com.zr.riskmanagement.pojo;

import lombok.Data;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskreserveCapitalsideMiddle {//风险准备金-主表和资金方表中间表
    private Integer id;
    private Integer riskreserveId;//基本信息表ID
    private Integer capitalsideId;//资金方ID

}
