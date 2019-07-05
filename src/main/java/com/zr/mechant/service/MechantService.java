package com.zr.mechant.service;



import com.zr.mechant.model.MechantAddVo;
import com.zr.mechant.model.MechantSelectVo;
import com.zr.mechant.model.MechantUpdateVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;


/**
 * Created by 86151 on 2019/4/22.
 */
public interface MechantService {


    ResultVO<AllRecords> queryPage(MechantSelectVo mechantSelectVo);
    ResultVO addMechant(MechantAddVo mechantAddVo);
    ResultVO updateMechant(MechantUpdateVo mechantUpdateVo);
    ResultVO queryMechantAll(Integer id);

}







