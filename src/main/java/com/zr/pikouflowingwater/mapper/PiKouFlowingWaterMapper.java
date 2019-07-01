package com.zr.pikouflowingwater.mapper;

import com.zr.pikouflowingwater.dto.PiKouFlowingWaterSelectVo;
import com.zr.pikouflowingwater.pojo.PiKouFlowingWater;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PiKouFlowingWaterMapper {
    List<PiKouFlowingWater> queryPage(PiKouFlowingWaterSelectVo piKouFlowingWaterSelectVo);

    int queryCount(PiKouFlowingWaterSelectVo piKouFlowingWaterSelectVo);
}
