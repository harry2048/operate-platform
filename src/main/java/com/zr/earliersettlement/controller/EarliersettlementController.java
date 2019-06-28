package com.zr.earliersettlement.controller;


import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.earliersettlement.pojo.XiaLaVo;
import com.zr.earliersettlement.service.EarliersettlementService;
import com.zr.meiju.StatusEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21.
 */
@CrossOrigin
@RestController
@RequestMapping("earliersettlement")
public class EarliersettlementController {

    @Autowired
    private EarliersettlementService earliersettlementService;
    /**
     * 下拉框
     */
    @GetMapping("queryDownByearliersettlementId")
    public ResultVO<List<Earliersettlement>> queryDownByearliersettlementId(@RequestParam("id")Integer id){
        return earliersettlementService.queryDownByearliersettlementId(id);
    }

    /**
     * 状态下拉框
     */
    @GetMapping("xiala")
    public ResultVO<List<XiaLaVo>> queryXiaLa(){

        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< StatusEnum.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setKey(i);
            xiaLaVo.setValue(StatusEnum.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

    /**
     * 分页查询
     */
    @PostMapping("queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody EarliersettlementSelectVo earliersettlementSelectVo){
        return earliersettlementService.queryPage(earliersettlementSelectVo);
    }


    //导出
    //1.定义一个导出模板
    //2.从数据库中查询出将要导出的数据
    //3.把从数据库中查询出的数据赋值给导出模板
    //4.对需要转化的数据进行转化
    //5.在浏览器生成一个文件
    @GetMapping("master")
    public ResultVO exportExcel(HttpServletResponse resp, String businessType, String orderNum, Date settleTime,Date loanTime,
                                String managemen,Integer channel,String customerName,String idCode) throws Exception{
        EarliersettlementSelectVo earliersettlementSelectVo = new EarliersettlementSelectVo();
        earliersettlementSelectVo.setBusinessType(businessType);
        earliersettlementSelectVo.setOrderNum(orderNum);
        earliersettlementSelectVo.setSettleTime(settleTime);
        earliersettlementSelectVo.setLoanTime(loanTime);
        earliersettlementSelectVo.setManagemen(managemen);
        earliersettlementSelectVo.setChannel(channel);
        earliersettlementSelectVo.setCustomerName(customerName);
        earliersettlementSelectVo.setIdCode(idCode);
        return earliersettlementService.exportExcel(resp,earliersettlementSelectVo);
    }
}
