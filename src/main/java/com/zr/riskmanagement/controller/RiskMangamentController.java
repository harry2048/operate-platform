package com.zr.riskmanagement.controller;

import com.zr.riskmanagement.pojo.RiskReserveAddVo;
import com.zr.riskmanagement.service.RiskMangamentService;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 94818 on 2019/6/22.
 */
@RestController
public class RiskMangamentController {

    @Autowired
    private RiskMangamentService riskMangamentService;

    @PostMapping("riskMa/add")
    private ResultVO add(@RequestBody RiskReserveAddVo riskReserveAddVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOBuilder.error("500",bindingResult.getFieldError().getDefaultMessage());
        }
       return riskMangamentService.add(riskReserveAddVo);
    }
}
