package com.zr.daishenpi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by ZLFamily on 2019/7/9.
 */
@Mapper
public interface DaiShenPiMapper {

//修改状态
    @Update("update paydivide set status=#{status} where id=#{id}")
    int updateShenPi(@Param("status")Integer status,@Param("id") Integer id);

}
