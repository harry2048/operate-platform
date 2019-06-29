package com.zr.loansituation.controller;

import com.zr.loansituation.pojo.Loansituation;
import com.zr.loansituation.pojo.LoansituationSelectVo;
import com.zr.loansituation.pojo.XiaLaVo;
import com.zr.loansituation.service.LoansituationService;
import com.zr.meiju.EnquiryStatus;
import com.zr.meiju.EnquiryStatus2;
import com.zr.meiju.EnquiryStatus3;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Creaetd by star on 2019/6/21.
 */
@RestController
@RequestMapping("daikuanchaxun/")
public class LoansituationController {

    @Autowired
    private LoansituationService loansituationService;

    /**
     * 下拉框
     */
    @GetMapping("queryLoansituationById")
    public ResultVO<List<Loansituation>> queryPlanClassById(@RequestParam("id") Integer id){
        return loansituationService.queryLoansituationById(id);
    }

    /**
     * 分页
     */
    @PostMapping("queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody LoansituationSelectVo loansituationSelectVo){

        return loansituationService.queryPage(loansituationSelectVo);
    }

    @PostMapping("testPost")
    public String testPost(@RequestBody List<String> aa){
        return "aaa";
    }

    /**
     * 推送状态下拉框-----meiju-----EnquiryStatus
     */
    @PostMapping("enquiry/enquiryStatus")
    public ResultVO<List<XiaLaVo>> enquiryStatus(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< EnquiryStatus.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(EnquiryStatus.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

    /**
     * 贷鱼贷款状态下拉框-----meiju-----EnquiryStatus2
     */
    @PostMapping("enquiry/enquiryStatus2")
    public ResultVO<List<XiaLaVo>> enquiryStatus2(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< EnquiryStatus2.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(EnquiryStatus2.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

    /**
     * 签章状态下拉框-----meiju-----EnquiryStatus3
     */
    @PostMapping("enquiry/enquiryStatus3")
    public ResultVO<List<XiaLaVo>> enquiryStatus3(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< EnquiryStatus3.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(EnquiryStatus3.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

//    资方状态----下拉
    @PostMapping("queryAll")
    public ResultVO queryAll(){
        return loansituationService.queryAll();
    }

    //    进件渠道---下拉
    @PostMapping("queryAll2")
    public ResultVO queryAll2(){
        return loansituationService.queryAll2();
    }




}
