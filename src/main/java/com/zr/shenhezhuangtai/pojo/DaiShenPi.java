package com.zr.shenhezhuangtai.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: gengwei
 * @Date: 2019-07-09 15:03
 * @Description:
 */
@Data
public class DaiShenPi {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date jinjiandate; // 进件时间

    private String name;// 客户姓名

    private String qudaoName;// 渠道名称

    private String daikuanType;// 贷款类型

    private String zijinfang;// 资金方

    private Integer status;// 推送状态
    private String statusName;

    private String shenhePerson;// 审核人

    private String leijiYongshi;// 累计用时
}
