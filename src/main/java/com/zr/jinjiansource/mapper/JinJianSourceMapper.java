package com.zr.jinjiansource.mapper;

import com.zr.jinjiansource.dto.JinJianSourceOutputVo;
import com.zr.jinjiansource.dto.JinJianSourceSelectVo;
import com.zr.jinjiansource.pojo.JinJianSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JinJianSourceMapper{

    List<JinJianSource> queryPage(JinJianSourceSelectVo jinJianSourceSelectVo);

    int queryCount(JinJianSourceSelectVo jinJianSourceSelectVo);

    List<JinJianSourceOutputVo> queryByJinJianSourceOutputVo(JinJianSourceOutputVo jianSourceOutputVo);

    int queryCountByJinJianSourceOutputVo(JinJianSourceOutputVo jianSourceOutputVo);
}
