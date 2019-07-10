package com.zr.daishenpi.service;

import com.zr.daishenpi.pojo.DaiShenPiSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

/**
 * Created by ZLFamily on 2019/7/9.
 */
public interface DaiShenPiService {

    //修改
    ResultVO updateShenPi(Integer status, Integer id);

    //分页
    ResultVO<AllRecords> queryByPage(DaiShenPiSelectVo daiShenPiSelectVo);

}
