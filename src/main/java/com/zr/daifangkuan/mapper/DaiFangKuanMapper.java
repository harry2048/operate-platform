package com.zr.daifangkuan.mapper;

import com.zr.daifangkuan.entity.DaiFangKuanEntity;
import com.zr.daifangkuan.entity.DaiFangKuanSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:35
 */
@Mapper
@Repository
public interface DaiFangKuanMapper{

    //根据条件查询
    List<DaiFangKuanEntity> findAll(DaiFangKuanSelectVo daiFangKuanSelectVo);

    //查询总数量
    Integer queryCount();
}
