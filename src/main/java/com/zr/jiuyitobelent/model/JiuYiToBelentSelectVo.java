package com.zr.jiuyitobelent.model;
import com.zr.util.PageVo;
import lombok.Data;

/**
 * Created by Administrator on 2019/6/4.
 */
@Data
public class JiuYiToBelentSelectVo extends PageVo {
    private String channel;//资方
    private Integer managementStatus;//资方状态
    private String managementStatusName;//资方状态名称
    private String customerName;//姓名
    private String phone;//手机号
    private String merchant;//商户
}
