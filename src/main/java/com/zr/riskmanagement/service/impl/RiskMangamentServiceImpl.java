package com.zr.riskmanagement.service.impl;

import com.zr.riskmanagement.mapper.RiskMapper;
import com.zr.riskmanagement.pojo.*;
import com.zr.riskmanagement.service.RiskMangamentService;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Created by 94818 on 2019/6/22.
 */
@Service
public class RiskMangamentServiceImpl implements RiskMangamentService {
    @Autowired
    private RiskMapper riskMapper;

    @Override
    @Transactional
    public ResultVO add(RiskReserveAddVo riskReserveAddVo) {
        //商户ID不能为空
        if(StringUtils.isEmpty(riskReserveAddVo.getRemeId())){
            return ResultVOBuilder.error("500","商户ID不能为空");
        }else{
            RiskReserve riskReserve=new RiskReserve();
            riskReserve.setRemeId(riskReserveAddVo.getRemeId());
            riskReserve.setLineCredit(riskReserveAddVo.getLineCredit());
            riskReserve.setReserveCoefficient(riskReserveAddVo.getReserveCoefficient());
            riskReserve.setRiskReserve(riskReserveAddVo.getRiskReserve());
            riskMapper.addRiskReserve(riskReserve);
            if(!StringUtils.isEmpty(riskReserveAddVo.getCapitalSide())){
                RiskreserveCapitalsideMiddle risksideMiddle =new RiskreserveCapitalsideMiddle();
                RiskreserveCapitalside byCapitalName = riskMapper.findByCapitalName(riskReserveAddVo.getCapitalSide());
                if(byCapitalName!=null){
                    risksideMiddle.setCapitalsideId(byCapitalName.getId());
                }else{
                    return ResultVOBuilder.error("500","查询不到风险准备金-资金方表信息");
                }
                risksideMiddle.setRiskreserveId(riskReserve.getId());
                riskMapper.addSideMiddle(risksideMiddle);
            }
            if(!StringUtils.isEmpty(riskReserveAddVo.getPic())) {
                RiskReserveZiliao riskReserveZiliao =new RiskReserveZiliao();
                riskReserveZiliao.setPic(riskReserveAddVo.getPic());
                riskReserveZiliao.setRiskReserveId(riskReserve.getId());
                riskMapper.addRiskZiliao(riskReserveZiliao);
            }
        }

        return ResultVOBuilder.success(riskReserveAddVo);
    }
}
