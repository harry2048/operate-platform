package com.zr.jiuyitobelent.mapper;

import com.zr.jiuyitobelent.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * Created by 86151 on 2019/4/22.
 */
@Mapper
public interface JiuYiToBelentMapper {

    //查询数据库条数
    int queryCount(JiuYiToBelentSelectVo jiuYiToBelentSelectVo);

    //查询数据库数据
    List<JiuYiToBelent> queryPage(JiuYiToBelentSelectVo jiuYiToBelentSelectVo);

    List<JiuYiToBelent> queryByJiuYiToBelentSelectVo(JiuYiToBelentSelectVo jiuYiToBelentSelectVo);
   /* //添加8张表
    @Insert("insert into mechant (merchantName,merchantLegalPerson,merchantAddress,merchantDesc,foreignPhone,phone,createTime,createName,updateTime,updateName) value (#{merchantName},#{merchantLegalPerson},#{merchantAddress},#{merchantDesc},#{foreignPhone},#{phone},#{createTime},#{createName},#{updateTime},#{updateName})")
    int addMechant(Mechant mechant);

    @Insert("insert into mechant_pic (startTime,endTime) value (#{startTime},#{endTime})")
    int addMp(Mechant_Pic mp);

   @Insert("insert into mechant_configure (mechanismType,landingAccount,landingPassword,type,isStore,isCreateStore,channelMaintenance,isAddHousingResources,isDeduction,isGrantAuthorization,isActiveRepayment,education,renting,digital,blueWaterSource,huaBei,medicalBeauty,monthlyRentPayment,apartmentType)" +
                                   " value(#{mechanismType},#{landingAccount},#{landingPassword},#{type},#{isStore},#{isCreateStore},#{channelMaintenance},#{isAddHousingResources},#{isDeduction},#{isGrantAuthorization},#{isActiveRepayment},#{education},#{renting},#{digital},#{blueWaterSource},#{huaBei},#{medicalBeauty},#{monthlyRentPayment},#{apartmentType}) ")
    int addMc(Mechant_Configure mc);

    @Insert("insert into mechant_speedprogress (management,remark,status,code,mechant_id)" +
            " value(#{management},#{remark},#{status},#{code},#{mechant_id})")
    int addMs(Mechant_SpeedProgress ms);

    @Insert("insert into mechant_capital (accountType,accountName,openBank,bankAccount,advanceDays,oneRate,rate)" +
            " value(#{accountType},#{accountName},#{openBank},#{bankAccount},#{advanceDays},#{oneRate},#{rate}) ")
    int addMca(Merchant_Capital mca);

    @Insert("insert into mechant_generatinginformation (bankCard,affiliatedBank,mailbox,province,jointLineNumber,accountName,lenderAddress,lenderPhone,bankCity,createTime,createName,updateTime,updateName)" +
            " value(#{bankCard},#{affiliatedBank},#{mailbox},#{province},#{jointLineNumber},#{accountName},#{lenderAddress},#{lenderPhone},#{bankCity},#{createTime},#{createName},#{updateTime},#{updateName}) ")
    int addMg(Mechant_Generatinginformation mg);

    @Insert("insert into mechant_zhifubao (zhifubaoAccount,zhifubaoPid)" +
            " value(#{zhifubaoAccount},#{zhifubaoPid}) ")
    int addMz(Mechant_ZhiFuBao mz);

    @Insert("insert into mechant_other (id, pic) value(#{id},#{pic})")
    int addMo(Mechant_Other mo);

    //根据id查询
    @Select("select merchantName from mechant where id={id}")
    Mechant queryMechantById(Integer id);

    //修改
    @Update("update mechant set merchantName=#{merchantName},merchantAddress=#{merchantAddress} where id=#{id}")
    int updateMechant(Mechant mechant);
    @Update("update mechant_configure set channelMaintenance=#{channelMaintenance}")
    int updataMp(Mechant_Configure mechant_configure);
    @Update("update mechant_pic set startTime =#{startTime},endTime =#{endTime}")
    int updateMc(Mechant_Pic mechant_pic);
    @Update("update mechant_speedprogress set status=#{status}")
    int updateMs(Mechant_SpeedProgress mechant_speedprogress);*/
}
