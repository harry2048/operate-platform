package com.zr.loansituation.mapper;

import com.zr.loansituation.pojo.Loansituation;
import com.zr.loansituation.pojo.LoansituationSelectVo;
import com.zr.loansituation.pojo.Maintenancestaff;
import com.zr.loansituation.pojo.Riskreserve_Capitalside;
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

    List<Loansituation> queryPage2(LoansituationSelectVo loansituationSelectVo);
    int queryCount2(LoansituationSelectVo loansituationSelectVo);

    @Select("select * from riskreserve_capitalside")
    List<Riskreserve_Capitalside> queryAll();

    @Select("select * from maintenancestaff")
    List<Maintenancestaff> queryAll2();



}
