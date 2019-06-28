package com.zr.xinshenstatistics.controller;

import com.zr.xinshenstatistics.pojo.XinshenstatisticsVO;
import com.zr.xinshenstatistics.service.XinshenstatisticsService;
import com.zr.xinshenstatistics.util.AllRecords;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * Created by jiangping on 2019/6/21.
 */
@RestController
public class XinshenstatisticsController {
    @Autowired
    private XinshenstatisticsService xinshenstatisticsService;
    @PostMapping("queryPage")
    public ResultVo<AllRecords> queryPage(@RequestBody XinshenstatisticsVO xinshenstatisticsVO){

        return xinshenstatisticsService.queryPage(xinshenstatisticsVO);
    }
    /**
     * 查看
     */
    @GetMapping("queryById")
    public ResultVo queryById(@RequestParam("id")Integer id){

        return xinshenstatisticsService.queryById(id);
    }
    //导出
    //1.定义一个导出模板
    //2.从数据库中查询出将要导出的数据
    //3.把从数据库中查询出的数据赋值给导出模板
    //4.对需要转化的数据进行转化
    //5.在浏览器生成一个文件
    @GetMapping("/exportExcel/master")
    public ResultVo exportExcel(HttpServletResponse resp,String scopeOfBusiness,
                                String orderNum,String Auditors,Integer status,
                                Date applyTime,Date chuShenTime,
                                Date fuShenTime,Date approvalTime,
                                Integer channel,String storeName,
                                String customerName,String idCode,
                                Integer phone,Date loanTime,
                                Double applicationAmount,
                                Double loanBalance,Double periodicContributions,
                                Integer applicationDeadline, String managemen,
                                Double overdueAmount,Integer overdueNum

    ) throws Exception{
        XinshenstatisticsVO xinshenstatisticsVO = new XinshenstatisticsVO();
        xinshenstatisticsVO.setOrderNum(orderNum);
        xinshenstatisticsVO.setAuditors(Auditors);
        xinshenstatisticsVO.setStatus(status);
        xinshenstatisticsVO.setApplyTime(applyTime);
        xinshenstatisticsVO.setChuShenTime(chuShenTime);
        xinshenstatisticsVO.setChannel(channel);
        xinshenstatisticsVO.setFuShenTime(fuShenTime);
        xinshenstatisticsVO.setApprovalTime(approvalTime);
        xinshenstatisticsVO.setStoreName(storeName);
        xinshenstatisticsVO.setCustomerName(customerName);
        xinshenstatisticsVO.setIdCode(idCode);
        xinshenstatisticsVO.setPhone(phone);
        xinshenstatisticsVO.setLoanTime(loanTime);
        xinshenstatisticsVO.setApplicationAmount(applicationAmount);
        xinshenstatisticsVO.setLoanBalance(loanBalance);
        xinshenstatisticsVO.setPeriodicContributions(periodicContributions);
        xinshenstatisticsVO.setApplicationDeadline(applicationDeadline);
        xinshenstatisticsVO.setOverdueAmount(overdueAmount);
        xinshenstatisticsVO.setManagemen(managemen);
        xinshenstatisticsVO.setOverdueNum(overdueNum);
        xinshenstatisticsVO.setScopeOfBusiness(scopeOfBusiness);
        return xinshenstatisticsService.exportExcel(resp,xinshenstatisticsVO);
    }
}

