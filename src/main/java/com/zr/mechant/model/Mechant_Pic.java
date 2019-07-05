package com.zr.mechant.model;




import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_Pic {
    private Integer id;
    private Date startTime  ;
    private Date  endTime;
    private Integer picId;
    private Integer mechantId;//外键
}
