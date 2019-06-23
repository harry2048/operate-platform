package com.zr.xinshendaily.service;

import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshendaily.pojo.CapitalSelectVo;
import com.zr.xinshendaily.pojo.TenantSelectVo;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 94818 on 2019/6/21.
 */
public interface CreditDailyService {

    ResultVO<AllRecords> queryPage(CapitalSelectVo capitalSelectVo);

    ResultVO exportExcel(HttpServletResponse resp, CapitalSelectVo capitalSelectVo) throws Exception;

    ResultVO<AllRecords> queryTenantPage(TenantSelectVo tenantSelectVo);

    ResultVO exportTenantExcel(HttpServletResponse resp, TenantSelectVo tenantSelectVo)throws Exception;
}
