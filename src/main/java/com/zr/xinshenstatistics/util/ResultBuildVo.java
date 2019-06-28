package com.zr.xinshenstatistics.util;

import lombok.Data;

/**
 * Created by 86151 on 2019/4/23.
 */
@Data
public class ResultBuildVo<T>{

    public static ResultVo error(String errorMessage, String errorCode ){
        ResultVo resultVo = new ResultVo();
        resultVo.setErrorMessage(errorMessage);
        resultVo.setSuccess(false);
        resultVo.setErrorCode(errorCode);
        return resultVo;
    }

    public static<T> ResultVo<T> success(T t) {//static<T> 表明将改方法声明为泛型方法
        ResultVo<T> result = new ResultVo<>();
        result.setData(t);
        result.setSuccess(true);
        return result;
    }
}
