package com.zr.daifangkuan.controller;

import com.zr.daifangkuan.entity.DaiFangKuanEntity;
import com.zr.daifangkuan.entity.DaiFangKuanSelectVo;
import com.zr.daifangkuan.entity.PullDown;
import com.zr.daifangkuan.service.DaiFangKuanService;
import com.zr.util.AllRecords;
import com.zr.util.DFKStatusEnum;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:34
 */
@RestController
@CrossOrigin
public class DaiFangKuanController {

    @Autowired
    private DaiFangKuanService daiFangKuanService;


    /**
     * 导出
     */
    @PostMapping("/daifangkuan/InquiryIntroduction")
    public ResultVO exportDFK(HttpServletResponse response,String statusName, String name, Integer phone, String merchant){
        DaiFangKuanSelectVo daiFangKuanSelectVo = new DaiFangKuanSelectVo();
        daiFangKuanSelectVo.setStatusName(statusName);
        daiFangKuanSelectVo.setName(name);
        daiFangKuanSelectVo.setMerchant(merchant);
        daiFangKuanSelectVo.setPhone(phone);
        return daiFangKuanService.exportDFK(response, daiFangKuanSelectVo);
    }


    /**
     * 分页查询
     * @param daiFangKuanSelectVo
     * @return
     */
    @PostMapping("/daifangkuan/queryPage")
    public ResultVO<AllRecords> DFKqueryPage(@RequestBody DaiFangKuanSelectVo daiFangKuanSelectVo){
        return daiFangKuanService.queryPage(daiFangKuanSelectVo);
    }

    /**
     * 状态下拉框
     */
    @PostMapping("/daifangkuan/getPullDownList")
    public ResultVO<List<PullDown>> findPullDownList(){
        List<PullDown> dfkStatusEnumList = new ArrayList<>();
        for(int i = 0; i <DFKStatusEnum.values().length; i ++){
            PullDown pullDown = new PullDown();
            pullDown.setVarlue(i);
            pullDown.setLabel(DFKStatusEnum.getStatusName(i));
            dfkStatusEnumList.add(pullDown);
        }
        return ResultVOBuilder.success(dfkStatusEnumList);
    }

}
