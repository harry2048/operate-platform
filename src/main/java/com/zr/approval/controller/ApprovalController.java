package com.zr.approval.controller;

import com.zr.approval.approvalEnum.IsApprovalEnum;
import com.zr.approval.approvalEnum.StatusEnmu;
import com.zr.approval.pojo.Approval;
import com.zr.approval.pojo.ApprovalSelectVo;
import com.zr.approval.pojo.IsApprovalVo;
import com.zr.approval.pojo.StatusEnmuVo;
import com.zr.approval.service.ApprovalService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@RestController
public class ApprovalController {


    @Autowired
    private ApprovalService approvalService;

    @PostMapping("findAll")
    public List<Approval> findAll(){

        return approvalService.findAll();
    }
    //分页查询
    @PostMapping("queryByPage")
    public ResultVO<AllRecords> queryByPage(@RequestBody ApprovalSelectVo approvalSelectVo){

        return approvalService.queryByPage(approvalSelectVo);
    }

    //导出
    @GetMapping("/exprotExcel")
    public ResultVO exportExcel(HttpServletResponse response,ApprovalSelectVo approvalSelectVo)throws Exception{
        List<ApprovalSelectVo> approvalSelectVoList=new ArrayList<>();
        approvalSelectVoList.add(approvalSelectVo);
        return approvalService.exportExcel(response,approvalSelectVoList);

    }
    //下拉列表(isApprovalSpinner)
    @PostMapping("isApprovalSpinner")
    public ResultVO<List<IsApprovalVo>>  isApprovalSpinner(){
        List<IsApprovalVo> isApprovalVos=new ArrayList<>();
        for(int i=0;i< IsApprovalEnum.values().length;i++){
            IsApprovalVo isApprovalVo=new IsApprovalVo();
            isApprovalVo.setIsApprovalValue(i);
            isApprovalVo.setIsApprovalName(IsApprovalEnum.getisApprovalName(i));
            isApprovalVos.add(isApprovalVo);
        }
        return ResultVOBuilder.success(isApprovalVos);

    }
    //下拉列表(statusSpinner)
    @PostMapping("statusSpinner")
    public ResultVO<List<StatusEnmuVo>> statusSpinner(){
        List<StatusEnmuVo> statusEnmuVoList= new ArrayList<>();
        for (int i = 0; i< StatusEnmu.values().length; i++){
            StatusEnmuVo statusEnmuVo = new StatusEnmuVo();
            statusEnmuVo.setStatusValue(i);
            statusEnmuVo.setStatusName(StatusEnmu.getstatusName(i));
            statusEnmuVoList.add(statusEnmuVo);
        }
        return ResultVOBuilder.success(statusEnmuVoList);
    }



}
