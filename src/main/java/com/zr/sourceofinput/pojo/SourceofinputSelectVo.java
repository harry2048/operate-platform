package com.zr.sourceofinput.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@Data
public class SourceofinputSelectVo extends PageVo {


    private String merchant;//'商户1

    private String customerName;//客户姓名1
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTime;//进件时间1

    private String orderNum;

    private String idCode;

    private String incomingPartsProvince;

    private String incomingPartsCity;

    private String specificAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTimeStart;//进件开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date incomingPartsTimeEnd;//进件结束时间


}
