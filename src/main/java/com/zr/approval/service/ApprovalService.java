package com.zr.approval.service;

import com.zr.approval.pojo.Approval;
import com.zr.approval.pojo.ApprovalSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
public interface ApprovalService {


    ResultVO<AllRecords> queryByPage(ApprovalSelectVo pprovalSelectVo);


    ResultVO exportExcel(HttpServletResponse response, List<ApprovalSelectVo> approvalSelectVo)throws Exception;


}
