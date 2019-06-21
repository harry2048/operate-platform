package com.zr.pikouflowingwater.service.impl;

import com.zr.jinjiansource.pojo.JinJianSource;
import com.zr.pikouflowingwater.dto.DeductionStatusResultVo;
import com.zr.pikouflowingwater.dto.PiKouFlowingWaterSelectVo;
import com.zr.pikouflowingwater.enums.DeductionResultsEnum;
import com.zr.pikouflowingwater.enums.DeductionStatusEnum;
import com.zr.pikouflowingwater.mapper.PiKouFlowingWaterMapper;
import com.zr.pikouflowingwater.pojo.PiKouFlowingWater;
import com.zr.pikouflowingwater.service.PiKouFlowingWaterService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PiKouFlowingWaterServiceImpl implements PiKouFlowingWaterService {
    @Autowired
    private PiKouFlowingWaterMapper piKouFlowingWaterMapper;

    @Override
    public ResultVO queryPage(PiKouFlowingWaterSelectVo piKouFlowingWaterSelectVo) {
        if (piKouFlowingWaterSelectVo.getPageIndex() == 0) {
            return ResultVOBuilder.error("500", "当前页不能为0");
        } else if (piKouFlowingWaterSelectVo.getPageSize() == 0) {
            return ResultVOBuilder.error("500", "每页记录数不能为0");
        }

        //查询数据
        List<PiKouFlowingWater> piKouFlowingWaterList = piKouFlowingWaterMapper.queryPage(piKouFlowingWaterSelectVo);
//        SimpleDateFormat shifenmiao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (PiKouFlowingWater p : piKouFlowingWaterList) {
            p.setDeductionResultsName(DeductionResultsEnum.getMsg(p.getDeductionResults()));
            p.setDeductionStatusName(DeductionStatusEnum.getMsg(p.getDeductionStatus()));
        }

        //查询数量
        int count = piKouFlowingWaterMapper.queryCount(piKouFlowingWaterSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(piKouFlowingWaterSelectVo.getPageIndex());
        allRecords.setPageSize(piKouFlowingWaterSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(piKouFlowingWaterList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVO queryDeductionStatusAll() {
        List<DeductionStatusResultVo> statusResultVos = new ArrayList<>();
        for (DeductionStatusEnum d : DeductionStatusEnum.values()) {
            statusResultVos.add(new DeductionStatusResultVo(d.getCode(), d.getMsg()));
        }
        return ResultVOBuilder.success(statusResultVos);
    }
}
