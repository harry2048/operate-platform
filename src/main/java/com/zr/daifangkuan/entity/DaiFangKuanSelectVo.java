package com.zr.daifangkuan.entity;

import com.zr.util.PageVo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:34
 */
@Data
public class DaiFangKuanSelectVo extends PageVo {

    private String statusName;//资方状态
    private String  name;//姓名',
    private Integer phone;//手机号',
    private String  merchant;//商户',
    //当前页数
//    private int pageIndex;
    //默认每页条数
//    private int pageSize;

}
