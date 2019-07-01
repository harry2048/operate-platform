package com.zr.sendrepaymentmessage.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class SendMessageSelectVo extends PageVo {

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date deliveryTime;

}