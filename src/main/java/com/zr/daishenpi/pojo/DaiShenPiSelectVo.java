package com.zr.daishenpi.pojo;

import com.zr.util.PageVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ZLFamily on 2019/7/9.
 */
@Data
public class DaiShenPiSelectVo extends PageVo {

    @Id //主键
    @GeneratedValue //自增
    private Integer id;

    private Date incomingPartsTime;//进件时间

    @NotBlank(message = "客户姓名不能为空！")
    private String merchant;//客户姓名

    @NotBlank(message = "渠道名称不能为空！")
    private String channel;//渠道名称

    @NotNull(message = "贷款类型不能为空！")
    private Integer daikuanTyep;//贷款类型

    @NotBlank(message = "资金方不能为空！")
    private String capitalSide;//资金方

    @NotBlank(message = "历史审核人不能为空！")
    private String auditors;//历史审核人

    @NotNull(message = "状态不能为空！")
    private Integer status;//状态

}
