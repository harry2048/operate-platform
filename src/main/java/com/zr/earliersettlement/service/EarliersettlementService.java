package com.zr.earliersettlement.service;

import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21.
 */
public interface EarliersettlementService {
    ResultVO<List<Earliersettlement>> queryDownByearliersettlementId(Integer id);
    ResultVO<AllRecords> queryPage(EarliersettlementSelectVo earliersettlementSelectVo);
    ResultVO exportExcel(HttpServletResponse resp, EarliersettlementSelectVo earliersettlementSelectVo)throws Exception;
}
