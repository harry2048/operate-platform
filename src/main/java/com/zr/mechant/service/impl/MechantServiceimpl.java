package com.zr.mechant.service.impl;


import com.zr.mechant.enumall.StatusEnum;
import com.zr.mechant.mapper.MechantMapper;

import com.zr.mechant.model.*;
import com.zr.mechant.service.MechantService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


/**
 * Created by 86151 on 2019/4/22.
 */
@Service
public class MechantServiceimpl implements MechantService {
    @Autowired
    private MechantMapper mechantMapper;


    @Override
    public ResultVO<AllRecords> queryPage(MechantSelectVo mechantSelectVo) {
       //1.查询总条数
        int count = mechantMapper.queryCount(mechantSelectVo);
        //2.查询具体数据信息
        List<MechantInfo> mechantInfos = mechantMapper.queryPage(mechantSelectVo);
        for (MechantInfo me : mechantInfos) {
            if (me.getStatus()!=null&&!StringUtils.isEmpty(me.getStatus())){
                if (me.getStatus()==0){
                    me.setStatusName(StatusEnum.WEIQIYONG.getStatusName());
                }else if(me.getStatus()==1){
                    me.setStatusName(StatusEnum.YIQIYONG.getStatusName());
                }else {
                    me.setStatusName(StatusEnum.YIDAOQI.getStatusName());
                }
            }
        }
        //3.new AllRecords给allRecordes赋值
        AllRecords allRecords = new AllRecords();
        allRecords.setTotalNumber(count);
        allRecords.setPageSize(mechantSelectVo.getPageSize());
        allRecords.setPageIndex(mechantSelectVo.getPageIndex());
        allRecords.setDataList(mechantInfos);
        allRecords.resetTotalNumber(count);


        //4.返回allRecordes
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    @Transactional
    public ResultVO addMechant(MechantAddVo mechantAddVo) {
        Mechant mechant = new Mechant();
        Mechant_Pic mp = new Mechant_Pic();
        Mechant_Configure mc = new  Mechant_Configure();
        Mechant_SpeedProgress ms = new Mechant_SpeedProgress();
        Merchant_Capital mca = new Merchant_Capital();
        Mechant_ZhiFuBao mz = new Mechant_ZhiFuBao();
        Mechant_Generatinginformation mg = new Mechant_Generatinginformation();
        Mechant_Other mo = new Mechant_Other();
        BeanUtils.copyProperties(mechantAddVo, mechant);
        BeanUtils.copyProperties(mechantAddVo, mp);
        BeanUtils.copyProperties(mechantAddVo, mc);
        BeanUtils.copyProperties(mechantAddVo, ms);
        BeanUtils.copyProperties(mechantAddVo, mca);
        BeanUtils.copyProperties(mechantAddVo, mg);
        BeanUtils.copyProperties(mechantAddVo, mz);
        BeanUtils.copyProperties(mechantAddVo, mo);
        mechant.setCreateName("小明");
        mechant.setCreateTime(new Date());
        mechantMapper.addMechant(mechant);
        mechantMapper.addMp(mp);
        mechantMapper.addMc(mc);
        mechantMapper.addMs(ms);
        mechantMapper.addMca(mca);
        mechantMapper.addMg(mg);
        mechantMapper.addMz(mz);
        mechantMapper.addMo(mo);

        return ResultVOBuilder.success(mechantAddVo);
    }

    @Override
    @Transactional
    //修改
    public ResultVO updateMechant(MechantUpdateVo mechantUpdateVo) {
        Mechant mechant1 =  mechantMapper.queryMechantById(mechantUpdateVo.getId());

        if (mechant1 == null){
          return ResultVOBuilder.error("您要修改的数据不存在！","500");
        }

        Mechant mechant = new Mechant();
        Mechant_Configure mechant_configure = new  Mechant_Configure();
        Mechant_Pic mechant_pic = new Mechant_Pic();
        Mechant_SpeedProgress mechant_speedprogress = new Mechant_SpeedProgress();
        BeanUtils.copyProperties(mechantUpdateVo,mechant);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_pic);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_configure);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_speedprogress);

        mechantMapper.updateMechant(mechant);
        mechantMapper.updataMp(mechant_configure);
        mechantMapper.updateMc(mechant_pic);
        mechantMapper.updateMs(mechant_speedprogress);
        return ResultVOBuilder.success(mechantUpdateVo);

//        int update = mechantMapper.updateMechant(mechantUpdateVo);
//        if (update == 0){
//            return ResultVOBuilder.error("数据已更新，请重新修改！","500");
//        }


    }

}
