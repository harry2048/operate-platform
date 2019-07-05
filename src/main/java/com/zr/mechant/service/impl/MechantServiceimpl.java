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
       // Mechant_Pic mp = new Mechant_Pic();
        Mechant_Configure mc = new  Mechant_Configure();
       // Mechant_SpeedProgress ms = new Mechant_SpeedProgress();
        Merchant_Capital mca = new Merchant_Capital();
        Mechant_ZhiFuBao mz = new Mechant_ZhiFuBao();
        Mechant_Generatinginformation mg = new Mechant_Generatinginformation();
     //   Mechant_Other mo = new Mechant_Other();
        BeanUtils.copyProperties(mechantAddVo, mechant);
        int i = mechantMapper.addMechant(mechant);
        if(i==0){
            return ResultVOBuilder.error("500","添加失败，请检查您的信息");
        }
        //mp.setMechantId(mechant.getId());
        mc.setMechantId(mechant.getId());
       // ms.setMechantId(mechant.getId());
        mca.setMechantId(mechant.getId());
        mg.setMechantId(mechant.getId());
        mz.setMechantId(mechant.getId());
     //   mo.setMechantId(mechant.getId());


        //BeanUtils.copyProperties(mechantAddVo, mp);
        BeanUtils.copyProperties(mechantAddVo, mc);
       // BeanUtils.copyProperties(mechantAddVo, ms);
        BeanUtils.copyProperties(mechantAddVo, mca);
        BeanUtils.copyProperties(mechantAddVo, mg);
        BeanUtils.copyProperties(mechantAddVo, mz);
       // BeanUtils.copyProperties(mechantAddVo, mo);
        mechant.setCreateName("小明");
        mechant.setCreateTime(new Date());

        mechantMapper.addMp(mechantAddVo.getMechantPicList());
        mechantMapper.addMc(mc);
        mechantMapper.addMs(mechantAddVo.getMechant_speedProgressList());
        mechantMapper.addMca(mca);
        mechantMapper.addMg(mg);
        mechantMapper.addMz(mz);
        mechantMapper.addMo(mechantAddVo.getMechant_otherList());

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

        Mechant_Generatinginformation mechant_generatinginformation=new Mechant_Generatinginformation();
        Mechant_Other mechant_other=new Mechant_Other();
        Mechant_ZhiFuBao mechant_zhiFuBao=new Mechant_ZhiFuBao();
        Merchant_Capital merchant_capital=new Merchant_Capital();


        BeanUtils.copyProperties(mechantUpdateVo,mechant);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_pic);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_configure);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_speedprogress);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_generatinginformation);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_other);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_zhiFuBao);
        BeanUtils.copyProperties(mechantUpdateVo, merchant_capital);

        mechantMapper.updateMechant(mechant);
        mechantMapper.updataMp(mechant_configure);
        mechantMapper.updatePicList(mechantUpdateVo.getMechantPicList());
        mechantMapper.updateSpeedProgressList(mechantUpdateVo.getMechant_speedProgressList());
        mechantMapper.updateMg(mechant_generatinginformation);
        mechantMapper.updateOtherList(mechantUpdateVo.getMechant_otherList());
        mechantMapper.updateMz(mechant_zhiFuBao);
        mechantMapper.updateMcp(merchant_capital);

        return ResultVOBuilder.success(mechantUpdateVo);

//        int update = mechantMapper.updateMechant(mechantUpdateVo);
//        if (update == 0){
//            return ResultVOBuilder.error("数据已更新，请重新修改！","500");
//        }


    }

    @Override
    public ResultVO queryMechantAll(Integer id){

        if(id==null){
            return ResultVOBuilder.error("500","用户状态异常");

        }
        MechantUpdateVo mechantUpdateVo=mechantMapper.queryMechantAllById(id);
        List<Mechant_Other> mechant_othersList = mechantMapper.queryOtherByMid(id);
        List<Mechant_Pic> mechant_pics = mechantMapper.queryPicByMid(id);
        List<Mechant_SpeedProgress> mechant_speedProgresses = mechantMapper.querySpeedProgressByMid(id);
        mechantUpdateVo.setMechant_otherList(mechant_othersList);
        mechantUpdateVo.setMechant_speedProgressList(mechant_speedProgresses);
        mechantUpdateVo.setMechantPicList(mechant_pics);
        return ResultVOBuilder.success(mechantUpdateVo);
    }

}
