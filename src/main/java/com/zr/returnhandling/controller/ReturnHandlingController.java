package com.zr.returnhandling.controller;

import com.zr.returnhandling.enumutil.ReturnHandlingEnum;
import com.zr.returnhandling.model.ReturnHandlingSelectVo;
import com.zr.returnhandling.model.XiaLaVo;
import com.zr.returnhandling.service.ReturnHandlingService;
import com.zr.util.AllRecords;
import com.zr.util.PullDownUpdateConfigureMap;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//前端和后端端口不同：跨域的访问需要这个注解
@CrossOrigin
public class ReturnHandlingController {
    @Autowired
    private ReturnHandlingService returnHandlingService;

    /**
     * 分页查询接口
     */
    @PostMapping("returnHandling/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody ReturnHandlingSelectVo returnHandlingSelectVo) {

        return returnHandlingService.queryPage(returnHandlingSelectVo);
    }
    /**
     * 状态下拉框
     */
    @PostMapping("returnHandling/getPullDownList")
    public ResultVO<List<XiaLaVo>> queryXiaLa(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        ReturnHandlingEnum[] arr = ReturnHandlingEnum.values();
        for (int i = 0; i < arr.length; i++){

            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(arr[i].getSendingStatusValue());
            xiaLaVo.setLabel(arr[i].getSendingStatusName());
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }


}