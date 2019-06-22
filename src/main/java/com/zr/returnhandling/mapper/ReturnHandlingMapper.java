package com.zr.returnhandling.mapper;

import com.zr.returnhandling.model.ReturnHandlingSelectVo;
import com.zr.returnhandling.model.ReturnHandlingVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReturnHandlingMapper {

     List<ReturnHandlingVo> queryPage(ReturnHandlingSelectVo returnHandlingSelectVo) ;

     int queryCount(ReturnHandlingSelectVo returnHandlingSelectVo) ;
}
