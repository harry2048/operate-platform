package com.zr.sendrepaymentmessage.mapper;

import com.zr.sendrepaymentmessage.pojo.SendMessageSelectVo;
import com.zr.sendrepaymentmessage.pojo.SendRepaymentMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 王杰 on 2019/6/21.
 */
@Mapper
public interface SendMessageMapper {
    int queryTotalNumber(SendMessageSelectVo sendMessageSelectVo);

    List<SendRepaymentMessage> querySendMessagePage(SendMessageSelectVo sendMessageSelectVo);
}
