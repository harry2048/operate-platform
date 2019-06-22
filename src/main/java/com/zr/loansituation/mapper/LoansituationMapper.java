package com.zr.loansituation.mapper;

import com.zr.loansituation.pojo.Loansituation;
import com.zr.loansituation.pojo.LoansituationSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by star on 2019/6/21.
 */
@Mapper
public interface LoansituationMapper {
    @Select("select management,incomingPartsChannel from loansituation where id=#{id}")
    List<Loansituation> queryLoansituationById(Integer id);

    List<Loansituation> queryPage(LoansituationSelectVo loansituationSelectVo);
    int queryCount(LoansituationSelectVo loansituationSelectVo);



}
