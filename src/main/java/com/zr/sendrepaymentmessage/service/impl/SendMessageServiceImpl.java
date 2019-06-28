package com.zr.sendrepaymentmessage.service.impl;

import com.zr.sendrepaymentmessage.mapper.SendMessageMapper;
import com.zr.sendrepaymentmessage.pojo.SendMessageSelectVo;
import com.zr.sendrepaymentmessage.pojo.SendRepaymentMessage;
import com.zr.sendrepaymentmessage.service.SendMessageService;
import com.zr.sendrepaymentmessage.util.StatusEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 王杰 on 2019/6/21.
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {
    @Autowired
    private SendMessageMapper sendMessageMapper;
    @Override
    public ResultVO<AllRecords> querySendMessagePage(SendMessageSelectVo sendMessageSelectVo) {
        List<SendRepaymentMessage> list = sendMessageMapper.querySendMessagePage(sendMessageSelectVo);
        for (SendRepaymentMessage sendRepaymentMessage:list) {
            sendRepaymentMessage.setSendingStatusName(StatusEnum.getName(sendRepaymentMessage.getSendingStatus()));
        }
        int count = sendMessageMapper.queryTotalNumber(sendMessageSelectVo);
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(sendMessageSelectVo.getPageIndex());//当前页
        allRecords.setPageSize(sendMessageSelectVo.getPageSize());//每页大小
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(list);
        return ResultVOBuilder.success(allRecords);
    }
}
