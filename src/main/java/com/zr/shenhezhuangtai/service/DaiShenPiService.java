package com.zr.shenhezhuangtai.service;

import com.zr.shenhezhuangtai.pojo.DaiShenPiVo;
import com.zr.util.ResultVO;

/**
 * @Auther: gengwei
 * @Date: 2019-07-09 15:09
 * @Description:
 */
public interface DaiShenPiService {
    ResultVO getDaiShenPi(DaiShenPiVo piVo);

    ResultVO getShenpiliebiao(DaiShenPiVo daiShenPiVo);

    ResultVO queryShenpiById(Integer id);
}
