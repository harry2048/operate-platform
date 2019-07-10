package com.zr.shenhezhuangtai.mapper;

import com.zr.shenhezhuangtai.pojo.DaiShenPi;
import com.zr.shenhezhuangtai.pojo.DaiShenPiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: gengwei
 * @Date: 2019-07-09 15:04
 * @Description:
 */
@Mapper
public interface DaiShenPiMapper {

    @Select("select * from paydivide where status=1 limit #{offset},#{pageSize}")
    List<DaiShenPi> getDaiShenPi(DaiShenPiVo daiShenPiVo);

    @Select("select * from paydivide where status in (3,4) limit #{offset},#{pageSize}")
    List<DaiShenPi> getShenpiliebiao(DaiShenPiVo daiShenPiVo);

    @Select("select count(1) from paydivide where status=1")
    int queryCount(DaiShenPiVo daiShenPiVo);

    @Select("select count(1) from paydivide where status in (3,4)")
    int queryShenpiLiebiaoCount(DaiShenPiVo daiShenPiVo);

    @Select("select * from paydivide where id = #{id}")
    DaiShenPi queryShenpiById(@Param("id") Integer id);
}
