package com.zr.lendinglist.service;

import com.zr.lendinglist.model.LendingListSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2019/6/21.
 */
public interface LendingListService {
    ResultVO querylendinglistById(Integer id);

    ResultVO<AllRecords> queryPage(LendingListSelectVo lendingListSelectVo);

    ResultVO exportExcel(HttpServletResponse resp, LendingListSelectVo lendingListSelectVo) throws Exception;
}
