package com.zr.sourceofinput.mapper;

import com.zr.sourceofinput.pojo.Sourceofinput;
import com.zr.sourceofinput.pojo.SourceofinputSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@Mapper
public interface SourceofinputMapper {

    List<Sourceofinput> queryPage(SourceofinputSelectVo sourceofinputSelectVo);

    int queryCount(SourceofinputSelectVo sourceofinputSelectVo);

    List<Sourceofinput> queryBySelectVo(SourceofinputSelectVo sourceofinputSelectVo);

    @Select("select * from sourceofinput  where id=#{id}")
    Sourceofinput queryById(Integer id);
}
