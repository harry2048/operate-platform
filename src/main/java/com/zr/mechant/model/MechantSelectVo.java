package com.zr.mechant.model;
import com.zr.util.PageVo;
import lombok.Data;

/**
 * Created by Administrator on 2019/6/4.
 */
@Data
public class MechantSelectVo extends PageVo {

    private  String merchantName;//商户名称
    private Integer channelMaintenance;//维护渠道
    private Integer status;//商户状态
    //private 业务类型

}
