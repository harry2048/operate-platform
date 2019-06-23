package com.zr.creditaudit.controller;

import com.zr.creditaudit.dto.CreditAuditSelectVo;
import com.zr.creditaudit.service.CreditAuditService;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditAudit")
public class CreditAuditController {

    @Autowired
    private CreditAuditService creditAuditService;

    /**
     * 条件分页查询
     * @param creditAuditSelectVo
     * @return
     */
    @PostMapping("/queryBySelect")
    public ResultVO queryPage(@RequestBody CreditAuditSelectVo creditAuditSelectVo) {
        return creditAuditService.queryPage(creditAuditSelectVo);
    }

}
