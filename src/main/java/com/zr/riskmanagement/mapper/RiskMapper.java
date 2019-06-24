package com.zr.riskmanagement.mapper;

import com.zr.riskmanagement.pojo.RiskReserve;
import com.zr.riskmanagement.pojo.RiskReserveZiliao;
import com.zr.riskmanagement.pojo.RiskreserveCapitalside;
import com.zr.riskmanagement.pojo.RiskreserveCapitalsideMiddle;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by 94818 on 2019/6/22.
 */
@Repository
@Mapper
public interface RiskMapper {

    @Insert(" insert into riskreserve (riskReserve,lineCredit,reserveCoefficient,remeId  ) " +
            "values  ( #{riskReserve},#{lineCredit},#{reserveCoefficient},#{remeId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addRiskReserve(RiskReserve riskReserve);

    @Select(" select * from riskreserve_capitalside where capitalSide = #{capitalSide}")
    RiskreserveCapitalside findByCapitalName(String capitalSide);

    @Insert(" insert into riskreserve_capitalside_middle (riskreserveId,capitalsideId ) " +
            "values  ( #{riskreserveId},#{capitalsideId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addSideMiddle(RiskreserveCapitalsideMiddle risksideMiddle);

    @Insert(" insert into riskreserve_ziliao (pic,riskReserve_id ) values (#{pic},#{riskReserveId}) " )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addRiskZiliao(RiskReserveZiliao riskReserveZiliao);
}
