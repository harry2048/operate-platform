package com.zr.shenhezhuangtai.service.impl;

import com.zr.pikouflowingwater.enums.DeductionResultsEnum;
import com.zr.pikouflowingwater.enums.DeductionStatusEnum;
import com.zr.pikouflowingwater.pojo.PiKouFlowingWater;
import com.zr.shenhezhuangtai.mapper.DaiShenPiMapper;
import com.zr.shenhezhuangtai.pojo.DaiShenPi;
import com.zr.shenhezhuangtai.pojo.DaiShenPiVo;
import com.zr.shenhezhuangtai.service.DaiShenPiService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.shenpistatus.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: gengwei
 * @Date: 2019-07-09 15:10
 * @Description:
 */
@Service
public class DaiShenPiServiceImpl implements DaiShenPiService {

    @Autowired
    private DaiShenPiMapper daiShenPiMapper;

    /**
     * @author 耿威
     * @date 2019-07-09 16:25
     * @return
     * @throws
     * @description: 查询待审批列表
    */
    @Override
    public ResultVO getDaiShenPi(DaiShenPiVo daiShenPiVo) {
        if (daiShenPiVo.getPageIndex() == 0) {
            return ResultVOBuilder.error("500", "当前页不能为空");
            // 想修改pageSize类型为Integer，这样就能判断是否为null
        } else if (daiShenPiVo.getPageSize() == 0) {
            return ResultVOBuilder.error("500", "每页记录数不能为空");
        }

        //查询数据
        List<DaiShenPi> daiShenPiList = daiShenPiMapper.getDaiShenPi(daiShenPiVo);
        for (DaiShenPi d : daiShenPiList) {
            for (StatusEnum s : StatusEnum.values()) {
                if (d.getStatus() == s.getStatusValue()) {
                    d.setStatusName(s.getStatusName());
                }
            }
        }

        //查询数量
        int count = daiShenPiMapper.queryCount(daiShenPiVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(daiShenPiVo.getPageIndex());
        allRecords.setPageSize(daiShenPiVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(daiShenPiList);
        return ResultVOBuilder.success(allRecords);
    }

    /**
     * @author 耿威
     * @date 2019-07-09 16:25
     * @return
     * @throws
     * @description: 查询已审批列表
    */
    @Override
    public ResultVO getShenpiliebiao(DaiShenPiVo daiShenPiVo) {
        if (daiShenPiVo.getPageIndex() == 0) {
            return ResultVOBuilder.error("500", "当前页不能为空");
            // 想修改pageSize类型为Integer，这样就能判断是否为null
        } else if (daiShenPiVo.getPageSize() == 0) {
            return ResultVOBuilder.error("500", "每页记录数不能为空");
        }

        //查询数据
        List<DaiShenPi> daiShenPiList = daiShenPiMapper.getShenpiliebiao(daiShenPiVo);
        for (DaiShenPi d : daiShenPiList) {
            for (StatusEnum s : StatusEnum.values()) {
                if (d.getStatus() == s.getStatusValue()) {
                    d.setStatusName(s.getStatusName());
                }
            }
        }

        //查询数量
        int count = daiShenPiMapper.queryShenpiLiebiaoCount(daiShenPiVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(daiShenPiVo.getPageIndex());
        allRecords.setPageSize(daiShenPiVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(daiShenPiList);
        return ResultVOBuilder.success(allRecords);

    }

    @Override
    /**
     * @author 耿威
     * @date 2019-07-10 09:22
     * @param id
     * @return com.zr.util.ResultVO
     * @throws
     * @description: 根据id查询审批列表中每条数据的详情
    */
    public ResultVO queryShenpiById(Integer id) {
        DaiShenPi daiShenPi = daiShenPiMapper.queryShenpiById(id);
        return ResultVOBuilder.success(daiShenPi);
    }
}
