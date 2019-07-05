package com.zr.pikouflowingwater.controller;

import com.zr.pikouflowingwater.dto.PiKouFlowingWaterSelectVo;
import com.zr.pikouflowingwater.service.PiKouFlowingWaterService;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gengwei
 * @date 2019-07-05 13:03
 * @param
 * @return
 * @throws
 * @since
 * @description:
*/
@RestController
@RequestMapping("/pikouflowingwater")
public class PiKouFlowingWaterController {

    @Autowired
    private PiKouFlowingWaterService piKouFlowingWaterService;

    /**
     * @author gengwei
     * @date 2019-07-05 13:03
     * @param
     * @return
     * @throws
     * @since
     * @description: 分页带条件查询
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
