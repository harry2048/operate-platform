package com.zr.mechant.model;

import lombok.Data;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_ZhiFuBao {
    private  Integer id;
    private String  zhifubaoAccount;
    private String zhifubaoPid;
    private Integer mechantId;//外键
}
