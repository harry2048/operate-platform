package com.zr.earliersettlement.mapper;

import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.loansituation.pojo.Riskreserve_Capitalside;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/6/21.
 */
@Mapper
public interface EarliersettlementMapper {
    @Select("select businessType,managemen from earliersettlement where id = #{id}")
    List<Earliersettlement> queryBusinessTypeAndManagemen(Integer id);

    List<Earliersettlement> queryPage(EarliersettlementSelectVo earliersettlementSelectVo);
    int queryCount(EarliersettlementSelectVo earliersettlementSelectVo);
    List<Earliersettlement> queryBySelectVo(EarliersettlementSelectVo earliersettlementSelectVo);

    @Select("select * from riskreserve_capitalside")
    List<Riskreserve_Capitalside> queryAll();
}
