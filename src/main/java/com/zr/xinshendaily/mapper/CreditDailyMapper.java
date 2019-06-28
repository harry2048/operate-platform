package com.zr.xinshendaily.mapper;

import com.zr.xinshendaily.pojo.CapitalSelectVo;
import com.zr.xinshendaily.pojo.TenantSelectVo;
import com.zr.xinshendaily.pojo.Xinshendaily;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 94818 on 2019/6/21.
 */

@Mapper
@Repository
public interface CreditDailyMapper {
    List<Xinshendaily> queryPage(CapitalSelectVo capitalSelectVo);

    int queryCount(CapitalSelectVo capitalSelectVo);

    List<Xinshendaily> queryBySelectVo(CapitalSelectVo capitalSelectVo);

    List<Xinshendaily> queryTenantPage(TenantSelectVo tenantSelectVo);

    int queryTenantCount(TenantSelectVo tenantSelectVo);

    List<Xinshendaily> queryByTenantSelectVo(TenantSelectVo tenantSelectVo);
}
