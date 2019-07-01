package com.zr.xinshenstatistics.controller;

import com.zr.meiju.BusinessTypeEnum;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.pojo.XiaLaVo;
import com.zr.xinshenstatistics.pojo.XinshenstatisticsVO;
import com.zr.xinshenstatistics.service.XinshenstatisticsService;
import com.zr.xinshenstatistics.util.AllRecords;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by jiangping on 2019/6/21.
 */
@RestController
public class XinshenstatisticsController {
    @Autowired
    private XinshenstatisticsService xinshenstatisticsService;

    /**
     * 分页
     * @param xinshenstatisticsVO
     * @return
     */
    @PostMapping("queryPage")
    public ResultVo<AllRecords> queryPage(@RequestBody XinshenstatisticsVO xinshenstatisticsVO){

        return xinshenstatisticsService.queryPage(xinshenstatisticsVO);
    }
    /**
     * 查看
     */
    @GetMapping("Xinshen/queryAll")
    public ResultVo queryAll(){

        return xinshenstatisticsService.queryAll();
    }
    /**
     * 业务类型的枚举
     */
    @GetMapping("businessType")
    public ResultVO<List<XiaLaVo>> queryBusinessType(){

        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< BusinessTypeEnum.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setKey(i);
            xiaLaVo.setValue(BusinessTypeEnum.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

    //导出
    //1.定义一个导出模板
    //2.从数据库中查询出将要导出的数据
    //3.把从数据库中查询出的数据赋值给导出模板
    //4.对需要转化的数据进行转化
    //5.在浏览器生成一个文件
    @GetMapping("/exportExcel/master")
    public ResultVo exportExcel(HttpServletResponse resp,Integer scopeOfBusiness,
                                Integer managemen,
                                String channel,
                                String auditors

    ) throws Exception{
        XinshenstatisticsVO xinshenstatisticsVO = new XinshenstatisticsVO();
        xinshenstatisticsVO.setAuditors(auditors);
        xinshenstatisticsVO.setChannel(channel);
        xinshenstatisticsVO.setManagemen(managemen);
        xinshenstatisticsVO.setScopeOfBusiness(scopeOfBusiness);
        return xinshenstatisticsService.exportExcel(resp,xinshenstatisticsVO);
    }



}

