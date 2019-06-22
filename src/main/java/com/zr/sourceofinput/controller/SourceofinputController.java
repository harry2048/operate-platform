package com.zr.sourceofinput.controller;

import com.zr.sourceofinput.pojo.SourceofinputSelectVo;
import com.zr.sourceofinput.service.SourceofinputService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@RestController
@CrossOrigin
public class SourceofinputController {

    @Autowired
    private SourceofinputService sourceofinputService;

    /**
     * 分页
     */
    @PostMapping("sourceofinput/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody SourceofinputSelectVo sourceofinputSelectVo) {

        return sourceofinputService.queryPage(sourceofinputSelectVo);
    }

    /**
     * 查看
     */
    @GetMapping("querySourceofinputById")
    public ResultVO querySourceofinputById(@RequestParam("id") Integer id) {

        return sourceofinputService.querySourceofinputById(id);
    }
    //导出
    //1.定义一个导出模板
    //2.从数据库中查询出将要导出的数据
    //3.把从数据库中查询出的数据赋值给导出模板
    //4.对需要转化的数据进行转化
    //5.在浏览器生成一个文件
    @GetMapping("exportExcel/master")
    public ResultVO exportExcel(HttpServletResponse resp, String orderNum, String merchant, String customerName,
                                String idCode, Date incomingPartsTime,String incomingPartsProvince,
                                String incomingPartsCity,String specificAddress) throws Exception{
        SourceofinputSelectVo sourceofinputSelectVo = new SourceofinputSelectVo();
        sourceofinputSelectVo.setOrderNum(orderNum);
        sourceofinputSelectVo.setMerchant(merchant);
        sourceofinputSelectVo.setCustomerName(customerName);
        sourceofinputSelectVo.setIdCode(idCode);
        sourceofinputSelectVo.setIncomingPartsTime(incomingPartsTime);
        sourceofinputSelectVo.setIncomingPartsProvince(incomingPartsProvince);
        sourceofinputSelectVo.setIncomingPartsCity(incomingPartsCity);
        sourceofinputSelectVo.setSpecificAddress(specificAddress);
        return sourceofinputService.exportExcel(resp,sourceofinputSelectVo);
    }
}
