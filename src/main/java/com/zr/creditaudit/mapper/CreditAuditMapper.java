package com.zr.creditaudit.mapper;

import com.zr.creditaudit.dto.CreditAuditSelectVo;
import com.zr.creditaudit.pojo.CreditAudit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreditAuditMapper {
    List<CreditAudit> queryPage(CreditAuditSelectVo creditAuditSelectVo);

    int queryCount(CreditAuditSelectVo creditAuditSelectVo);
}
