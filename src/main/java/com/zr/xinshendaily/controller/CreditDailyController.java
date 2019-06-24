package com.zr.xinshendaily.controller;

import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshendaily.pojo.CapitalSelectVo;
import com.zr.xinshendaily.pojo.TenantSelectVo;
import com.zr.xinshendaily.service.CreditDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * Created by 94818 on 2019/6/21.
 */
@RestController
public class CreditDailyController {

    @Autowired
    private CreditDailyService creditDailyService;

/**
 * 资方日报表查询功能
 */

    @PostMapping("credit/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody CapitalSelectVo capitalSelectVo){
        return creditDailyService.queryPage(capitalSelectVo);
    }





/**
 * 资方日报表导出功能
 */
//导出
//1.定义一个导出模板
//2.从数据库中查询出将要导出的数据
//3.把从数据库中查询出的数据赋值给导出模板
//4.对需要转化的数据进行转化
//5.在浏览器生成一个文件
@GetMapping("credit/master")
public ResultVO exportExcel(HttpServletResponse resp,String merchant,Date startTime,Date endTime ) throws Exception{
    CapitalSelectVo capitalSelectVo =new CapitalSelectVo();
    capitalSelectVo.setMerchant(merchant);
    capitalSelectVo.setStartTime(startTime);
    capitalSelectVo.setEndTime(endTime);
    return creditDailyService.exportExcel(resp,capitalSelectVo);
}



/**
 * 商户日报表查询功能
 */
@PostMapping("tenant/queryPage")
public ResultVO<AllRecords> queryPage(@RequestBody TenantSelectVo tenantSelectVo){
    return creditDailyService.queryTenantPage(tenantSelectVo);
}



//商户日报表导出
//1.定义一个导出模板
//2.从数据库中查询出将要导出的数据
//3.把从数据库中查询出的数据赋值给导出模板
//4.对需要转化的数据进行转化
//5.在浏览器生成一个文件
@GetMapping("tenant/master")
public ResultVO exportTenantExcel(HttpServletResponse resp,String merchant,Date startTime,Date endTime ) throws Exception{
    TenantSelectVo tenantSelectVo=new TenantSelectVo();
    tenantSelectVo.setMerchant(merchant);
    tenantSelectVo.setStartTime(startTime);
    tenantSelectVo.setEndTime(endTime);
    return creditDailyService.exportTenantExcel(resp,tenantSelectVo);
}


}
