package com.zr.xinshenstatistics.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.xinshenstatistics.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by jiangping on 2019/6/21.
 */
@Data
public class XinshenstatisticsVO extends PageVo{
    private String auditors;//'审核人员'
    private String channel;//'渠道'
    private Integer managemen;//'资方'
    private Integer scopeOfBusiness;//'业务范围'



}
