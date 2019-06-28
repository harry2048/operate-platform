package com.zr.xinshenstatistics.util;

import lombok.Data;

/**
 * Created by 86151 on 2019/4/23.
 */
@Data
public class ResultVo<T> {
    private boolean isSuccess;
    private T data;
    private String errorMessage;
    private String errorCode;
}
