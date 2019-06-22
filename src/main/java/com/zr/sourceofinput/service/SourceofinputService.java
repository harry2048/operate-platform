package com.zr.sourceofinput.service;

import com.zr.sourceofinput.pojo.Sourceofinput;
import com.zr.sourceofinput.pojo.SourceofinputSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
public interface SourceofinputService {

    ResultVO<AllRecords> queryPage(SourceofinputSelectVo sourceofinputSelectVo);
    ResultVO<Sourceofinput> querySourceofinputById(Integer id);
    ResultVO exportExcel(HttpServletResponse resp, SourceofinputSelectVo sourceofinputSelectVo)throws Exception;
}

