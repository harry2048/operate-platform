package com.zr.jinjiansource.service;

import com.zr.jinjiansource.dto.JinJianSourceOutputVo;
import com.zr.jinjiansource.dto.JinJianSourceSelectVo;
import com.zr.util.ResultVO;

import javax.servlet.http.HttpServletResponse;

public interface JinJianSourceService {
    ResultVO queryPage(JinJianSourceSelectVo jinJianSourceSelectVo);

    ResultVO exportExcel(HttpServletResponse resp, JinJianSourceOutputVo jianSourceOutputVo) throws Exception;
}
