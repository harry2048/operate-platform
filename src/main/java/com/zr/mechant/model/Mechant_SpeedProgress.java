package com.zr.mechant.model;

import lombok.Data;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_SpeedProgress {
    private Integer id;
    private String management;
    private String remark;
    private Integer status;
    private String  code;
    private Integer mechantId;//外键
}
