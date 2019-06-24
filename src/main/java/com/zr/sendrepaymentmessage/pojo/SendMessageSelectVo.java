package com.zr.sendrepaymentmessage.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class SendMessageSelectVo extends PageVo {

    private Date deliveryTime;

}