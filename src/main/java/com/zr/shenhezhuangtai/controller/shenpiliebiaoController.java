package com.zr.shenhezhuangtai.controller;

import com.zr.shenhezhuangtai.pojo.DaiShenPiVo;
import com.zr.shenhezhuangtai.service.DaiShenPiService;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 耿威
 * @date 2019-07-05 13:03
 * @description: 审批列表
 */
@RestController
public class shenpiliebiaoController {
    @Autowired
    private DaiShenPiService daiShenPiService;

    /**
     * @return
     * @throws
     * @author 耿威
     * @date 2019-07-09 16:21
     * @description: 查看待审核列表
     */
    @PostMapping("/daishenpi")
    public ResultVO daishenpi(@RequestBody DaiShenPiVo daiShenPiVo) {
        return daiShenPiService.getDaiShenPi(daiShenPiVo);
    }

    /**
     * @return
     * @throws
     * @author 耿威
     * @date 2019-07-09 16:23
     * @description: 查看审批列表
     */
    @PostMapping("/shenpiliebiao")
    public ResultVO shenpiliebiao(@RequestBody DaiShenPiVo daiShenPiVo) {
        return daiShenPiService.getShenpiliebiao(daiShenPiVo);
    }

    /**
     * @author 耿威
     * @date 2019-07-10 09:19
     * @param id
     * @return ResultVO
     * @description: 根据id修改审批列表中的每条数据
    */
    @GetMapping("/queryShenpiById")
    public ResultVO queryShenpiById(@RequestParam("id") Integer id) {
        return daiShenPiService.queryShenpiById(id);
    }
}