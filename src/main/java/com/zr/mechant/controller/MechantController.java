package com.zr.mechant.controller;



import com.zr.mechant.model.MechantAddVo;
import com.zr.mechant.model.MechantSelectVo;
import com.zr.mechant.model.MechantUpdateVo;

import com.zr.mechant.service.MechantService;

import com.zr.util.AllRecords;

import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Created by 86151 on 2019/4/22.
 */
@RestController
@CrossOrigin
public class MechantController {
    @Autowired
    private MechantService mechantService;

    /**
     * 分页
     * @param mechantSelectVo
     * @return
     */
    @PostMapping("mechantCategory/select")
    public ResultVO<AllRecords> queryPage(@RequestBody MechantSelectVo mechantSelectVo){
        return mechantService.queryPage(mechantSelectVo);
    }

    /**
     * @param mechantAddVo
     * @param bindingResult
     * @return
     *    添加
     */
    @PostMapping("mechantCategory/add")

    public ResultVO addMechant(@RequestBody @Valid MechantAddVo mechantAddVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOBuilder.error(bindingResult.getFieldError().getDefaultMessage(), "500");
        }
        return mechantService.addMechant(mechantAddVo);


    }

    /**
     *
     * @param mechantUpdateVo
     * @param bindingResult
     * @return  修改
     */
    @PostMapping("mechantCategory/update")
    public ResultVO<MechantUpdateVo> updateStoreRoom(@RequestBody @Valid MechantUpdateVo mechantUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultVOBuilder.error(bindingResult.getFieldError().getDefaultMessage(),"500");
        }
        return mechantService.updateMechant(mechantUpdateVo);
    }


    /**
     * 下拉框
     * @return
     */
   /* @PostMapping("mechantCategory/select11")
    public ResultVO<AllRecords> queryPage111(){
        PullDownUpdateConfigureMap p = new PullDownUpdateConfigureMap();
        List<String> list = new ArrayList<>();
        ResultVO pullDownList = p.getPullDownList(list);
        return pullDownList;
    }*/

   @PostMapping("mechantCategory/queryById")
    public ResultVO queryById(@RequestParam("id") Integer id){

       return mechantService.queryMechantAll(id);
   }




}

