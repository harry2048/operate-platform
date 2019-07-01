package com.zr.pikouflowingwater.service;

import com.zr.pikouflowingwater.dto.PiKouFlowingWaterSelectVo;
import com.zr.util.ResultVO;

public interface PiKouFlowingWaterService {
    ResultVO queryPage(PiKouFlowingWaterSelectVo piKouFlowingWaterSelectVo);

    ResultVO queryDeductionStatusAll();

}
