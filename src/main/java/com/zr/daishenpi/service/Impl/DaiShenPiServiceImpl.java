package com.zr.daishenpi.service.Impl;


import com.zr.daishenpi.mapper.DaiShenPiMapper;
import com.zr.daishenpi.pojo.DaiShenPiSelectVo;
import com.zr.daishenpi.service.DaiShenPiService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZLFamily on 2019/7/9.
 */
@Service
public class DaiShenPiServiceImpl implements DaiShenPiService {

    @Autowired
    private DaiShenPiMapper daiShenPiMapper;

    /**
     * 修改状态
     */
    @Override
    @Transactional
    public ResultVO updateShenPi(Integer status, Integer id) {

        if(status ==null || id == null){
            return ResultVOBuilder.error("500","状态（主键）不能为空！");
        }
        daiShenPiMapper.updateShenPi(status,id);
        return ResultVOBuilder.success(null);
    }

    /**
     * 分页查询
     */
    @Override
    public ResultVO<AllRecords> queryByPage(DaiShenPiSelectVo daiShenPiSelectVo) {
        //查询数据
//        List<DaiShenPiSelectVo> daiShenPiSelectVoList = daiShenPiMapper.findAll();
//        //查询数量
////        Integer count = daiShenPiMapper.queryCount();
//        AllRecords allRecords = new AllRecords();
//        allRecords.setPageIndex(daiShenPiSelectVo.getPageIndex());
//        allRecords.setPageSize(daiShenPiSelectVo.getPageSize());
//        allRecords.setTotalNumber(count);
//        allRecords.resetTotalNumber(count);
//        allRecords.setDataList(daiShenPiSelectVoList);
//        return ResultVOBuilder.success(allRecords);
        return null;
    }
}
