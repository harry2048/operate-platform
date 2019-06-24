package com.zr.sendrepaymentmessage.controller;

import com.zr.sendrepaymentmessage.pojo.SendMessageSelectVo;
import com.zr.sendrepaymentmessage.service.SendMessageService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by 王杰 on 2019/6/21.
 */
@RestController
public class SendMessageController {
    @Autowired
    private SendMessageService sendMessageService;

    @PostMapping("querySendMessagePage")
    public ResultVO<AllRecords> querySendMessagePage(@RequestBody  SendMessageSelectVo sendMessageSelectVo){
        return sendMessageService.querySendMessagePage(sendMessageSelectVo);
    }
}
