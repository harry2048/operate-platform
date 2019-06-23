package com.zr.pikouflowingwater.controller;

import com.zr.pikouflowingwater.dto.PiKouFlowingWaterSelectVo;
import com.zr.pikouflowingwater.service.PiKouFlowingWaterService;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pikouflowingwater")
public class PiKouFlowingWaterController {

    @Autowired
    private PiKouFlowingWaterService piKouFlowingWaterService;

    /**
     * 条件分页查询
     * @param piKouFlowingWaterSelectVo
     * @return
     */
    @PostMapping("/queryBySelect")
    public ResultVO queryPage(@RequestBody PiKouFlowingWaterSelectVo piKouFlowingWaterSelectVo) {
        return piKouFlowingWaterService.queryPage(piKouFlowingWaterSelectVo);
    }

    /**
     * 查询批扣状态下拉框
     * @return
     */
    @GetMapping("/queryDeductionStatusAll")
    public ResultVO queryDeductionStatusAll() {
        return piKouFlowingWaterService.queryDeductionStatusAll();
    }
}
