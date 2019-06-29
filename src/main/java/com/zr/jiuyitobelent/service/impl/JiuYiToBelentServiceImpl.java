package com.zr.jiuyitobelent.service.impl;
import com.zr.jiuyitobelent.enumall.ManagementStatusEnum;
import com.zr.jiuyitobelent.mapper.JiuYiToBelentMapper;
import com.zr.jiuyitobelent.model.*;
import com.zr.jiuyitobelent.service.JiuYiToBelentService;
import com.zr.util.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by 86151 on 2019/4/22.
 */
@Service
public class JiuYiToBelentServiceImpl implements JiuYiToBelentService {
    @Autowired
    private JiuYiToBelentMapper jiuYiToBelentMapper;


    @Override
    public ResultVO<AllRecords> queryPage(JiuYiToBelentSelectVo jiuYiToBelentSelectVo) {
       //1.查询总条数
        int count = jiuYiToBelentMapper.queryCount(jiuYiToBelentSelectVo);
        //2.查询具体数据信息
        List<JiuYiToBelent> jiuYiToBelents = jiuYiToBelentMapper.queryPage(jiuYiToBelentSelectVo);
        for (JiuYiToBelent jiuYiToBelent : jiuYiToBelents) {
            if (jiuYiToBelent.getManagementStatus()!=null&&!StringUtils.isEmpty(jiuYiToBelent.getManagementStatus())){
                if(jiuYiToBelent.getManagementStatus()==0){
                    jiuYiToBelent.setManagementStatusName(ManagementStatusEnum.YIFANGKUAN.getManagementStatusName());
                }else if(jiuYiToBelent.getManagementStatus()==1){
                    jiuYiToBelent.setManagementStatusName(ManagementStatusEnum.YIJUJUE.getManagementStatusName());
                }else {
                    jiuYiToBelent.setManagementStatusName(ManagementStatusEnum.DAKUANSHIBAI.getManagementStatusName());
                }
            }
            //分页时申请时间使用字符串形式展示
        }
        //3.new AllRecords给allRecordes赋值
        AllRecords allRecords = new AllRecords();
        allRecords.setTotalNumber(count);
        allRecords.setPageSize(jiuYiToBelentSelectVo.getPageSize());
        allRecords.setPageIndex(jiuYiToBelentSelectVo.getPageIndex());
        allRecords.setDataList(jiuYiToBelents);
        allRecords.resetTotalNumber(count);

        //4.返回allRecordes
        return ResultVOBuilder.success(allRecords);
    }

    /**
     * 导出
     *  //1.定义一个导出模板
        //2.从数据库中查询出将要导出的数据
        //3.把从数据库中查询出的数据赋值给导出模板
        //4.对需要转化的数据进行转化
        //5.在浏览器生成一个文件
     */
    @Override
    public ResultVO exportExcel(HttpServletResponse response, JiuYiToBelentSelectVo jiuYiToBelentSelectVo)throws Exception {
        //2.从数据库中查询出将要导出的数据
        List<JiuYiToBelent> jiuYiToBelentList = jiuYiToBelentMapper.queryByJiuYiToBelentSelectVo(jiuYiToBelentSelectVo);
        for (JiuYiToBelent jiuYiToBelent:jiuYiToBelentList){
            jiuYiToBelent.setManagementStatusName(ManagementStatusEnum.getManagementStatusName(jiuYiToBelent.getManagementStatus()));
        }
        //限制，默认只允许导出10000条数据
        int count = jiuYiToBelentMapper.queryCount(jiuYiToBelentSelectVo);
        if (count>10000){
            return ResultVOBuilder.error("默认只允许导出10000条数据！请增加条件导出","500");
        }
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "91待放款列表导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/91待放款列表.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", jiuYiToBelentList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }
    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,List<JiuYiToBelent> jiuYiToBelentList, ServletOutputStream out) throws Exception {
        //POi读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            //向sheet1中赋值，设置样式
            toResultListValueInfo( sheet, jiuYiToBelentList);
        }
        //把数据写入到输出流中
        wb.write(out);
        //关闭poi方法
        wb.close();
    }
    /**
     * 插入excel表中项目信息
     * private Integer id;
     private  Date applyTime;//申请时间
     private String  channel;//渠道
     private Double amountOfApplication;//申请金额
     private Integer applicationDeadline;//申请期限
     private Double periodicContributions;//期供款
     private String customerName;//客户姓名
     private String idCode;//证件号
     private Double managementLoanAmount;//资方放款金额
     private Integer managementStatus;//资方状态
     private String managementStatusName;//资方状态名称
     * @param sheet
     */
    private void toResultListValueInfo(Sheet sheet, List<JiuYiToBelent> jiuYiToBelentList) {
        //从第五行开始赋值
        int row_column = 4;
        //遍历数据集合
        for (JiuYiToBelent obj : jiuYiToBelentList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, obj.getId() + "");
            // 给第二列申请时间赋值
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String applyTime= sdf.format(obj.getApplyTime());
            POIClass.toCellValue(row, 1, applyTime + "");
            // 给第3列渠道赋值
            POIClass.toCellValue(row, 2, obj.getChannel() + "");
            // 给第4列申请金额赋值
            POIClass.toCellValue(row, 3, obj.getAmountOfApplication() + "");
            // 给第5列申请期限赋值
            POIClass.toCellValue(row, 4, obj.getApplicationDeadline() + "");
            // 给第6列期供货赋值
            POIClass.toCellValue(row, 5, obj.getPeriodicContributions() + "");
            // 给第7列客户姓名赋值
            POIClass.toCellValue(row, 6, obj.getCustomerName() + "");
            // 给第8列证件号赋值
            POIClass.toCellValue(row, 7, obj.getIdCode() + "");
            // 给第9列资方放款金额赋值
            POIClass.toCellValue(row, 8, obj.getManagementLoanAmount() + "");
            //给第10列资方状态赋值
            POIClass.toCellValue(row, 9, obj.getManagementStatusName() + "");
            row_column++;
        }
    }
   /* @Override
    @Transactional
    public ResultVO addMechant(MechantAddVo mechantAddVo) {
        Mechant mechant = new Mechant();
        Mechant_Pic mp = new Mechant_Pic();
        Mechant_Configure mc = new Mechant_Configure();
        Mechant_SpeedProgress ms = new Mechant_SpeedProgress();
        Merchant_Capital mca = new Merchant_Capital();
        Mechant_ZhiFuBao mz = new Mechant_ZhiFuBao();
        Mechant_Generatinginformation mg = new Mechant_Generatinginformation();
        Mechant_Other mo = new Mechant_Other();
        BeanUtils.copyProperties(mechantAddVo, mechant);
        BeanUtils.copyProperties(mechantAddVo, mp);
        BeanUtils.copyProperties(mechantAddVo, mc);
        BeanUtils.copyProperties(mechantAddVo, ms);
        BeanUtils.copyProperties(mechantAddVo, mca);
        BeanUtils.copyProperties(mechantAddVo, mg);
        BeanUtils.copyProperties(mechantAddVo, mz);
        BeanUtils.copyProperties(mechantAddVo, mo);
        mechant.setCreateName("小明");
        mechant.setCreateTime(new Date());
        jiuYiToBelentMapper.addMechant(mechant);
        jiuYiToBelentMapper.addMp(mp);
        jiuYiToBelentMapper.addMc(mc);
        jiuYiToBelentMapper.addMs(ms);
        jiuYiToBelentMapper.addMca(mca);
        jiuYiToBelentMapper.addMg(mg);
        jiuYiToBelentMapper.addMz(mz);
        jiuYiToBelentMapper.addMo(mo);

        return ResultVOBuilder.success(mechantAddVo);
    }

    @Override
    @Transactional
    //修改
    public ResultVO updateMechant(MechantUpdateVo mechantUpdateVo) {
        Mechant mechant1 =  jiuYiToBelentMapper.queryMechantById(mechantUpdateVo.getId());

        if (mechant1 == null){
          return ResultVOBuilder.error("您要修改的数据不存在！","500");
        }

        Mechant mechant = new Mechant();
        Mechant_Configure mechant_configure = new Mechant_Configure();
        Mechant_Pic mechant_pic = new Mechant_Pic();
        Mechant_SpeedProgress mechant_speedprogress = new Mechant_SpeedProgress();
        BeanUtils.copyProperties(mechantUpdateVo,mechant);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_pic);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_configure);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_speedprogress);

        jiuYiToBelentMapper.updateMechant(mechant);
        jiuYiToBelentMapper.updataMp(mechant_configure);
        jiuYiToBelentMapper.updateMc(mechant_pic);
        jiuYiToBelentMapper.updateMs(mechant_speedprogress);
        return ResultVOBuilder.success(mechantUpdateVo);

//        int update = jiuYiToBelentMapper.updateMechant(mechantUpdateVo);
//        if (update == 0){
//            return ResultVOBuilder.error("数据已更新，请重新修改！","500");
//        }


    }*/

}
