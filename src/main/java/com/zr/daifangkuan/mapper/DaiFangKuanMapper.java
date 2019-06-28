package com.zr.daifangkuan.mapper;

import com.zr.daifangkuan.entity.DaiFangKuanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;


/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:35
 */
public interface DaiFangKuanMapper extends JpaRepository<DaiFangKuanEntity,Integer>, QueryDslPredicateExecutor {
    @Query(value = "select * from daifangkuan where if(?1 !=null,status=?1,1=1) and if(?2 !='',name=?2,1=1)" +
            "and if(?3 !=null,phone=?3,1=1) and if(?4 !='',merchant=?4,1=1)",nativeQuery = true)
    List<DaiFangKuanEntity> findAllByStatusAndNameAndPhoneAndMerchant(Integer status, String name, Integer phone, String merchant);
}
