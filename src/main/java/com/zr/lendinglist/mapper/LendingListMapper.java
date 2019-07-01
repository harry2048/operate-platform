package com.zr.lendinglist.mapper;

import com.zr.lendinglist.model.FundingClass;
import com.zr.lendinglist.model.LendingList;
import com.zr.lendinglist.model.LendingListSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/6/21.
 */
@Mapper
public interface LendingListMapper {

    @Select("select * from lendinglist where id=#{id}")
    LendingList querylendinglistById(Integer id);

    List<LendingList> queryPage(LendingListSelectVo lendingListSelectVo);
    int queryCount(LendingListSelectVo lendingListSelectVo);

    List<LendingList> queryBySelectVo(LendingListSelectVo lendingListSelectVo);

    @Select("select * from riskreserve_capitalside")
    List<FundingClass> queryAll();
}
