package com.zr.creditaudit.service.impl;

import com.zr.creditaudit.dto.CreditAuditResultVo;
import com.zr.creditaudit.dto.CreditAuditSelectVo;
import com.zr.creditaudit.mapper.CreditAuditMapper;
import com.zr.creditaudit.pojo.CreditAudit;
import com.zr.creditaudit.service.CreditAuditService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditAuditServiceImpl implements CreditAuditService {
    @Autowired
    private CreditAuditMapper creditAuditMapper;

    @Override
    public ResultVO queryPage(CreditAuditSelectVo creditAuditSelectVo) {
        if (creditAuditSelectVo.getPageIndex() == 0) {
            return ResultVOBuilder.error("500", "当前页不能为空");
            // 想修改pageSize类型为Integer，这样就能判断是否为null
        } else if (creditAuditSelectVo.getPageSize() == 0) {
            return ResultVOBuilder.error("500", "每页记录数不能为空");
        }

        //查询数据
        List<CreditAudit> creditAuditList = creditAuditMapper.queryPage(creditAuditSelectVo);
        // 转换 0.99为 99%
        List<CreditAuditResultVo> resultVoList =copyProperties(creditAuditList);


        //查询数量
        int count = creditAuditMapper.queryCount(creditAuditSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(creditAuditSelectVo.getPageIndex());
        allRecords.setPageSize(creditAuditSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(resultVoList);
        return ResultVOBuilder.success(allRecords);
    }

    private List<CreditAuditResultVo> copyProperties(List<CreditAudit> creditAuditList) {
        List<CreditAuditResultVo> resultVoList= new ArrayList<>();
        for (CreditAudit c : creditAuditList) {
            CreditAuditResultVo resultVo = new CreditAuditResultVo();
            BeanUtils.copyProperties(c,resultVo);
            resultVo.setAuditPassRats(c.getAuditPassRat()*100+"%");
            resultVo.setAuditFailRats(c.getAuditFailRat()*100+"%");
            resultVo.setCaseRefuseRats(c.getCaseRefuseRat()*100+"%");
            resultVo.setCaseCancelRats(c.getCaseCancelRat()*100+"%");
            resultVoList.add(resultVo);
        }
        return resultVoList;
    }

}
