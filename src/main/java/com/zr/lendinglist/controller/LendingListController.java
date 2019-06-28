package com.zr.lendinglist.controller;


import com.zr.lendinglist.model.LendingList;
import com.zr.lendinglist.model.LendingListSelectVo;
import com.zr.lendinglist.service.LendingListService;

import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21.
 */
@RestController
@CrossOrigin
@RequestMapping("/lending")
public class LendingListController {

    @Autowired
    private LendingListService lendingListService;

    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping("querylendinglistById")
    public ResultVO<List<LendingList>> querylendinglistById(@RequestParam("id")Integer id){
        return lendingListService.querylendinglistById(id);
    }

    /**
     * 分页查询
     * @param lendingListSelectVo
     * @return
     */
    @PostMapping("queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody LendingListSelectVo lendingListSelectVo){
        return lendingListService.queryPage(lendingListSelectVo);
    }


    /**
     * 导出
     * @param resp
     * @param fundingParty
     * @param merchant
     * @param customerName
     * @param idCode
     * @param applyAmount
     * @param applyTerm
     * @param discountMode
     * @param periodicContributions
     * @param managementLoanAmount
     * @param daiyuLoanAmount
     * @param loanStatus
     * @param graceperiod
     * @param applyTime
     * @param examineTime
     * @param lendingTime
     * @return
     * @throws Exception
     */
    @RequestMapping("/exportExcel/master")
    public ResultVO exportExcel(HttpServletResponse resp, Integer fundingParty, String merchant, String customerName, Integer idCode,
                             Double applyAmount, Integer applyTerm, Integer discountMode, Integer periodicContributions, Double managementLoanAmount,
                             Double daiyuLoanAmount, Integer loanStatus, Integer graceperiod, Date applyTime, Date examineTime, Date lendingTime
                                ) throws Exception{
        LendingListSelectVo lendingListSelectVo = new LendingListSelectVo();
        lendingListSelectVo.setFundingParty(fundingParty);
        lendingListSelectVo.setMerchant(merchant);
        lendingListSelectVo.setCustomerName(customerName);
        lendingListSelectVo.setIdCode(idCode);
        lendingListSelectVo.setApplyAmount(applyAmount);
        lendingListSelectVo.setApplyTerm(applyTerm);
        lendingListSelectVo.setDiscountMode(discountMode);
        lendingListSelectVo.setPeriodicContributions(periodicContributions);
        lendingListSelectVo.setManagementLoanAmount(managementLoanAmount);
        lendingListSelectVo.setDaiyuLoanAmount(daiyuLoanAmount);
        lendingListSelectVo.setLoanStatus(loanStatus);
        lendingListSelectVo.setGraceperiod(graceperiod);
        lendingListSelectVo.setApplyTime(applyTime);
        lendingListSelectVo.setExamineTime(examineTime);
        lendingListSelectVo.setLendingTime(lendingTime);
        return lendingListService.exportExcel(resp,lendingListSelectVo);
    }

}
