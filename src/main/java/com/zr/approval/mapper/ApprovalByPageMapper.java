package com.zr.approval.mapper;

import com.zr.approval.pojo.Approval;
import com.zr.approval.pojo.ApprovalSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/6/22 0022.
 */
@Repository
@Mapper
public interface ApprovalByPageMapper {


    List<ApprovalSelectVo> queryByPage(ApprovalSelectVo approvalSelectVo);

    Integer queryCount();

    Approval findById(@Param("id") Integer id);
}
