package com.zr.xinshenstatistics.mapper;


import com.zr.xinshenstatistics.pojo.Xinshenstatistics;
import com.zr.xinshenstatistics.pojo.XinshenstatisticsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 86151 on 2019/6/14.
 */
@Mapper
public interface XinshenstatisticsMapper {
    List<Xinshenstatistics> queryPage(XinshenstatisticsVO xinshenstatisticsVO);

    int queryCount(XinshenstatisticsVO xinshenstatisticsVO);
    List<Xinshenstatistics> queryBySelectVo(XinshenstatisticsVO xinshenstatisticsVO);
    @Select("select * from xinshenstatistics where id=#{id}")
    Xinshenstatistics queryById(Integer id);
}
