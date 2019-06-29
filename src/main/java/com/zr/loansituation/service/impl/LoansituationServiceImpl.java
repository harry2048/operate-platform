package com.zr.loansituation.service.impl;

import com.zr.loansituation.mapper.LoansituationMapper;
import com.zr.loansituation.pojo.Loansituation;
import com.zr.loansituation.pojo.LoansituationSelectVo;
import com.zr.loansituation.pojo.Maintenancestaff;
import com.zr.loansituation.pojo.Riskreserve_Capitalside;
import com.zr.loansituation.service.LoansituationService;
import com.zr.mechant.enumall.StatusEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by star on 2019/6/21.
 */
@Service
public class LoansituationServiceImpl implements LoansituationService{
    @Autowired
    private LoansituationMapper loansituationMapper;

    /**
     * 查看
     */
    @Override
    public ResultVO<List<Loansituation>> queryLoansituationById(Integer id) {
        List<Loansituation> loansituation = loansituationMapper.queryLoansituationById(id);
        if (loansituation==null){
            return ResultVOBuilder.error("查看数据不存在！","500");
        }
        return ResultVOBuilder.success(loansituation);
    }

   /**
     * 分页
     */
    @Override
    public ResultVO<AllRecords> queryPage(LoansituationSelectVo loansituationSelectVo) {
        //查询数据
        List<Loansituation> loansituationList = loansituationMapper.queryPage(loansituationSelectVo);

        //查询数量
        int count =  loansituationMapper.queryCount(loansituationSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(loansituationSelectVo.getPageIndex());
        allRecords.setPageSize(loansituationSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(loansituationList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVO queryAll() {
        List<Riskreserve_Capitalside> riskreserve_capitalsideList = loansituationMapper.queryAll();
        return ResultVOBuilder.success(riskreserve_capitalsideList);

    }

    @Override
    public ResultVO queryAll2() {
        List<Maintenancestaff> maintenancestaffList = loansituationMapper.queryAll2();
        return ResultVOBuilder.success(maintenancestaffList);
    }
}
