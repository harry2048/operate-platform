package com.zr.mechant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class MechantAddVo {
    private  Integer id;
    @NotBlank(message = "商户名称不能为空")
    private  String  merchantName;
    @NotBlank(message = "商户法人不能为空")
    private String merchantLegalPerson;
    private String merchantAddress;

    private String merchantDesc;
    @NotNull(message = "对外电话不能为空")
    private Integer foreignPhone;
    private Integer phone;

    @NotNull(message = "请填写卡号")
    private Integer bankCard;
    private String affiliatedBank;
    private String mailbox;
    private String province;
    private String jointLineNumber;
    private String lenderName;
    private  String lenderAddress;
    private  Integer lenderPhone;
    private  String  bankCity;


    //进度信息表mechant_speedprogress
//    private String management;
//    private String remark;
//    private Integer status;
//    private String statusName;
//    private String  code;
    //private Integer mechant_id;
    private List<Mechant_SpeedProgress> mechant_speedProgressList;

    //合同信息表 mechant_pic
    // private Date startTime  ;
    // private Date  endTime;
    private List<Mechant_Pic> mechantPicList;

    //配置信息表mechant_configure
    private  String landingAccount;
    private String landingPassword;
    private  Integer type;//商户类型名称
    private Integer isStore;//是否有门店
    private Integer isCreateStore;//是否能自建门店
    private Integer  isDeduction;//商户标识
    private  Integer isGrantAuthorization;//是否强制授权
    private Integer isActiveRepayment; //是否能主动还款
    private Integer education;  //教育
    private Integer renting;
    private Integer digital;
    private Integer blueWaterSource;
    private Integer huaBei;
    private Integer medicalBeauty;
    private Integer monthlyRentPayment;
    private Integer  channelMaintenance;
    //  private  Integer apartmentType;
//    private Integer isAddHousingResources;
//    private  Integer mechanismType;

    //资金信息表mechant_capital
    private Integer accountType;
    private String accountName;
    private  String openBank;
    private String bankAccount;
    private Integer advanceDays;
    private String oneRate;
    private String rate;

    //支付宝信息表mechant_zhifubao
    private String  zhifubaoAccount;
    private String zhifubaoPid;
    //其他信息表mechant_other
    //private String pic;
    private List<Mechant_Other> mechant_otherList;

    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;


}
