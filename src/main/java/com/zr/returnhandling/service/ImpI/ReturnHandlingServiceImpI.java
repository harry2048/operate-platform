package com.zr.returnhandling.service.ImpI;

import com.zr.mechant.enumall.StatusEnum;
import com.zr.mechant.model.MechantInfo;
import com.zr.pikouflowingwater.enums.DeductionResultsEnum;
import com.zr.pikouflowingwater.enums.DeductionStatusEnum;
import com.zr.pikouflowingwater.pojo.PiKouFlowingWater;
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
import org.springframework.util.StringUtils;

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
        for (ReturnHandlingVo Re : returnHandlingVoList) {
            if (Re.getSendingStatus()!=null&&!StringUtils.isEmpty(Re.getSendingStatus())){
                Re.setSendingStatusName(ReturnHandlingEnum.getName(Re.getSendingStatus()));
               /*
                if (Re.getSendingStatus()==0){
                    Re.setSendingStatusName(ReturnHandlingEnum.DAITIJIAO.getSendingStatusName());
                }else if(Re.getSendingStatus()==1){
                    Re.setSendingStatusName(ReturnHandlingEnum.DAISHENPI.getSendingStatusName());
                }else if(Re.getSendingStatus()==2){
                    Re.setSendingStatusName(ReturnHandlingEnum.DAICAIWUSHENPI.getSendingStatusName());
                }else if(Re.getSendingStatus()==3){
                    Re.setSendingStatusName(ReturnHandlingEnum.YIJUJUE.getSendingStatusName());
                }else if(Re.getSendingStatus()==4){
                    Re.setSendingStatusName(ReturnHandlingEnum.CAIWUTONGGUO.getSendingStatusName());
                }else if(Re.getSendingStatus()==5){
                    Re.setSendingStatusName(ReturnHandlingEnum.CAIWUJUJUE.getSendingStatusName());
                }else{

                }*/
            }
        }

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
