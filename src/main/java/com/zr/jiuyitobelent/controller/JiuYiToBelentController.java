package com.zr.jiuyitobelent.controller;


import com.zr.jiuyitobelent.enumall.ChannelEnum;
import com.zr.jiuyitobelent.enumall.ManagementStatusEnum;
import com.zr.jiuyitobelent.model.JiuYiToBelentSelectVo;
import com.zr.jiuyitobelent.model.XiaLaVo;
import com.zr.jiuyitobelent.service.JiuYiToBelentService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 86151 on 2019/4/22.
 */
@RestController
@CrossOrigin
@RequestMapping("jiuyitu/")
public class JiuYiToBelentController {
    //
    @Autowired
    private JiuYiToBelentService jiuYiToBelentService;

    /**
     * 分页
     * @param jiuYiToBelentSelectVo
     * @return
     */
    @PostMapping("queryByPage")
    public ResultVO<AllRecords> queryPage(@RequestBody JiuYiToBelentSelectVo jiuYiToBelentSelectVo){
        return jiuYiToBelentService.queryPage(jiuYiToBelentSelectVo);
    }

    /**
     * @param mechantAddVo
     * @param bindingResult
     * @return
     *    添加
     */
   /* @PostMapping("mechantCategory/add")

    public ResultVO addMechant(@RequestBody @Valid MechantAddVo mechantAddVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOBuilder.error(bindingResult.getFieldError().getDefaultMessage(), "500");
        }
        return mechantService.addMechant(mechantAddVo);


    }*/

    /**
     *
     * @param mechantUpdateVo
     * @param bindingResult
     * @return  修改
     */
    /*@PostMapping("mechantCategory/update")
    public ResultVO<MechantUpdateVo> updateStoreRoom(@RequestBody @Valid MechantUpdateVo mechantUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultVOBuilder.error(bindingResult.getFieldError().getDefaultMessage(),"500");
        }
        return mechantService.updateMechant(mechantUpdateVo);
    }*/



  /*  *//**
     * 资方下拉框
     *//*
    @PostMapping("selectChannel")
    public ResultVO<List<XiaLaVo>> queryChannelXiaLa(){

        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< ChannelEnum.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(ChannelEnum.getChannelName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }*/
    /**
     * 资方下拉框
     */
    @GetMapping("selectChannel1")
    public ResultVO queryChannelXiaLa1(){

        return jiuYiToBelentService.queryAll();
    }

    /**
     * 资方状态下拉框
     */
    @PostMapping("selectManagementStatus")
    public ResultVO<List<XiaLaVo>> queryManagementStatusXiaLa(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< ManagementStatusEnum.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(ManagementStatusEnum.getManagementStatusName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }
    //导出
    @GetMapping("exportExcel/master")
    public ResultVO exportExcel(HttpServletResponse resp, String channel, Integer managementStatus, String customerName,String phone,String merchant) throws Exception{
        JiuYiToBelentSelectVo jiuYiToBelentSelectVo = new JiuYiToBelentSelectVo();
        jiuYiToBelentSelectVo.setChannel(channel);
        jiuYiToBelentSelectVo.setManagementStatus(managementStatus);
        jiuYiToBelentSelectVo.setCustomerName(customerName);
        jiuYiToBelentSelectVo.setPhone(phone);
        jiuYiToBelentSelectVo.setMerchant(merchant);
        return jiuYiToBelentService.exportExcel(resp,jiuYiToBelentSelectVo);
    }
}

