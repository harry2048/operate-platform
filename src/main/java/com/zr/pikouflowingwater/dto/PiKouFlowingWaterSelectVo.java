package com.zr.pikouflowingwater.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class PiKouFlowingWaterSelectVo extends PageVo{

    private String daiKouNum;// 代扣流水号

    private String daiKuanHetongNum; // 代扣合同号

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createTime;//交易日期

    private Integer deductionStatus;//扣款状态



    public PiKouFlowingWaterSelectVo() {
    }

    public PiKouFlowingWaterSelectVo(String daiKouNum, String daiKuanHetongNum, Date createTime, Integer deductionStatus) {
        this.daiKouNum = daiKouNum;
        this.daiKuanHetongNum = daiKuanHetongNum;
        this.createTime = createTime;
        this.deductionStatus = deductionStatus;
    }
}
