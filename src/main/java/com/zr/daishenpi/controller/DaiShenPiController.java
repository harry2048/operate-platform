package com.zr.daishenpi.controller;

import com.zr.daishenpi.pojo.DaiShenPiSelectVo;
import com.zr.daishenpi.service.DaiShenPiService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZLFamily on 2019/7/9.
 */
@RestController
public class DaiShenPiController {

    @Autowired
    private DaiShenPiService daiShenPiService;

    /**
     * 分页查询
     */
    @PostMapping("queryByPage")
    public ResultVO<AllRecords> queryByPage(@RequestBody DaiShenPiSelectVo daiShenPiSelectVo){
        return daiShenPiService.queryByPage(daiShenPiSelectVo);
    }

    /**
     * 修改审批接口
     */
    @GetMapping("/updateShenPi")
    public ResultVO updateShenPi(@RequestParam("status")Integer status,@RequestParam("id")Integer id){
        return daiShenPiService.updateShenPi(status,id);
    }

}
