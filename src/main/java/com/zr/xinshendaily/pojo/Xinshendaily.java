package com.zr.xinshendaily.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Xinshendaily {
    private Integer id;//主键id

    private String typeName;//日报表类型

    private String merchant;//商户名称

    private Double passAmount;//通过金额

    private Integer shenPiNum;//审批总数

    private Integer passNum;//通过数量

    private Integer juJueNum;//拒绝数量

    private Integer dahuiNum;//打回数量

    private Integer quXiaoNum;//取消数量

    private Integer tongGuoLu;//通过率

    private Integer amountBiLi;//金额比例

    private Integer informationXuJia;//信息虚假

    private Integer shutdown;//关机/空号/停机

    private Integer noJinJianBiaoZhun;//不符合进件标准

    private Integer productYuApplyBuFu;//产品与申请不符

    private Integer temporaryID;//临时身份证/身份证过期

    private Integer noUse;//非本人使用/非本人申请

    private Integer duoShiDuanZhanXian;//多时段拨打占线/无人接听/拒接

    private Integer applyWuYe;//申请人无业/工作不稳定

    private Integer xianZhiHangYe;//限制行业

    private Integer buPeiHeShenHe;//不配合审核

    private Integer gaoFengXianKeHu;//高风险客户

    private Integer tongXunLuWuXiao;//通讯录信息无效/未授权通讯录/非实名手机/在网时间短

    private Integer huanKuanLiBuZu;//还款能力不足

    private Integer juJueYuanYin;//拒绝原因-其他原因

    private Integer juJueYuanYinQiTa;//拒绝原因-其他

    private Integer zhuDongQuXiaoYeWu;//申请人主动取消办理此业务

    private Integer ziLiaoBuQuan;//资料不全/不清晰/不合规

    private Integer lianXiRenGouTong;//申请人需要与业务/联系人沟通

    private Integer xinXiTianXieError;//信息填写错误

    private Integer wuFaBangDing;//银行卡无法绑定

    private Integer quXiaoYuanYin;//取消原因-其他原因

    private Integer juJie;//多次拨打占线/无人接听/拒接

    private Integer applyZhuDongQuxiao;//申请人主动取消办理此业务

    private Integer jziLiaoBuQuan;//资料不全/不清晰/不合规

    private Integer xuYaoYuYeWuGouTong;//申请人需要与业务/联系人沟通

    private Integer xinXiTianXieCuoWu;//信息填写错误

    private Integer yinHangKaWuFaBangDing;//银行卡无法绑定

    private Integer daHuiYuanYin;//其他原因

    private Date createTime;//创建人时间

    private String createName;//创建人姓名

    private Date updateTime;//修改人时间

    private String updateName;//修改人姓名

    }