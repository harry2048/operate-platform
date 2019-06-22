package com.zr.returnhandling.service.ImpI;

import com.zr.returnhandling.enumutil.ReturnHandlingEnum;
import com.zr.returnhandling.mapper.ReturnHandlingMapper;
import com.zr.returnhandling.model.ReturnHandlingSelectVo;
import com.zr.returnhandling.model.ReturnHandlingVo;
import com.zr.returnhandling.service.ReturnHandlingService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReturnHandlingServiceImpI implements ReturnHandlingService {
    @Autowired
    private ReturnHandlingMapper returnHandlingMapper;
    @Override
    public ResultVO<AllRecords> queryPage(ReturnHandlingSelectVo returnHandlingSelectVo) {
        //查询数据
        List<ReturnHandlingVo> returnHandlingVoList = returnHandlingMapper.queryPage(returnHandlingSelectVo);
        //查询数量
        int count =  returnHandlingMapper.queryCount(returnHandlingSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(returnHandlingSelectVo.getPageIndex());
        allRecords.setPageSize(returnHandlingSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(returnHandlingVoList);
        return ResultVOBuilder.success(allRecords);
    }
}
