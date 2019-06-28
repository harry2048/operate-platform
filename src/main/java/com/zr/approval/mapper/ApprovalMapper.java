package com.zr.approval.mapper;

import com.zr.approval.pojo.Approval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * 查询的mapper 做单表查询使用
 * Created by Administrator on 2019/6/21 0021.
 */
public interface ApprovalMapper extends JpaRepository<Approval,Integer>{


}
