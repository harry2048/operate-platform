package com.zr.sendrepaymentmessage.service;

import com.zr.sendrepaymentmessage.pojo.SendMessageSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

/**
 * Created by 王杰 on 2019/6/21.
 */
public interface SendMessageService {
    ResultVO<AllRecords> querySendMessagePage(SendMessageSelectVo sendMessageSelectVo);
}
