package com.zr.returnhandling.service;

import com.zr.returnhandling.model.ReturnHandlingSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

public interface ReturnHandlingService {

    ResultVO<AllRecords> queryPage(ReturnHandlingSelectVo returnHandlingSelectVo);
}
