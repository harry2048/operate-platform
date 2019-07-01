package com.zr.xinshenstatistics.service;


import com.zr.xinshenstatistics.pojo.XinshenstatisticsVO;
import com.zr.xinshenstatistics.util.AllRecords;
import com.zr.xinshenstatistics.util.ResultVo;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 86151 on 2019/6/14.
 */
public interface XinshenstatisticsService {

    ResultVo<AllRecords> queryPage(XinshenstatisticsVO xinshenstatisticsVO);

    ResultVo exportExcel(HttpServletResponse resp, XinshenstatisticsVO xinshenstatisticsVO)throws Exception;

    ResultVo queryAll();
}
