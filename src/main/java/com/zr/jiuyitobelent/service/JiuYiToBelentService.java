package com.zr.jiuyitobelent.service;

import com.zr.jiuyitobelent.model.JiuYiToBelentSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by 86151 on 2019/4/22.
 */
public interface JiuYiToBelentService {


    ResultVO<AllRecords> queryPage(JiuYiToBelentSelectVo jiuYiToBelentSelectVo);

    ResultVO exportExcel(HttpServletResponse resp, JiuYiToBelentSelectVo jiuYiToBelentSelectVo) throws Exception;

    ResultVO queryAll();
//    ResultVO addMechant(MechantAddVo mechantAddVo);
//    ResultVO updateMechant(MechantUpdateVo mechantUpdateVo);
}







