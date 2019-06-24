package com.zr.creditaudit.service;

import com.zr.creditaudit.dto.CreditAuditSelectVo;
import com.zr.util.ResultVO;

public interface CreditAuditService {
    ResultVO queryPage(CreditAuditSelectVo creditAuditSelectVo);

}
