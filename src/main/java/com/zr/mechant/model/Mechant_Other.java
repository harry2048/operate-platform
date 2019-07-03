package com.zr.mechant.model;

import lombok.Data;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_Other {
    private Integer id;
    private String pic;
    private Integer mechantId;//外键
}
