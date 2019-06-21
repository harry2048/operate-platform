package com.zr.mechant.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant {

    private Integer id;
    //@NotBlank(message = "商户名称不能为空")
    private  String  merchantName;
    private String merchantLegalPerson;
    private String merchantAddress;
    private String merchantDesc;
    private Integer foreignPhone;
    private Integer phone;
    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;

}
