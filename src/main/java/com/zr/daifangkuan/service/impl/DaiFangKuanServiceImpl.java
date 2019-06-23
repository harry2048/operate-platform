package com.zr.daifangkuan.service.impl;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.zr.daifangkuan.entity.DaiFangKuanEntity;
import com.zr.daifangkuan.entity.DaiFangKuanSelectVo;
import com.zr.daifangkuan.entity.QDaiFangKuanEntity;
import com.zr.daifangkuan.mapper.DaiFangKuanMapper;
import com.zr.daifangkuan.service.DaiFangKuanService;
import com.zr.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:33
 */
@Service
@Slf4j
public class DaiFangKuanServiceImpl implements DaiFangKuanService {

    @Autowired
    private DaiFangKuanMapper daiFangKuanMapper;

    /**
     * 导出
     */
    @Override
    public ResultVO exportDFK(HttpServletResponse response, DaiFangKuanSelectVo daiFangKuanSelectVo) {
        //从数据库中查询将要导出的数据
        List<DaiFangKuanEntity> daiFangKuanEntityList = daiFangKuanMapper.findAllByStatusAndNameAndPhoneAndMerchant(DFKStatusEnum.getStatusValue(daiFangKuanSelectVo.getStatusName()),daiFangKuanSelectVo.getName(), daiFangKuanSelectVo.getPhone(), daiFangKuanSelectVo.getMerchant());
        for(DaiFangKuanEntity daiFangKuanEntity : daiFangKuanEntityList){
            daiFangKuanEntity.setStatusName(DFKStatusEnum.getStatusName(daiFangKuanEntity.getStatus()));
        }
        //限制，默认只允许导出10000条
        List<DaiFangKuanEntity> count = daiFangKuanMapper.findAll();
        if(count.size() > 10000){
            return ResultVOBuilder.error("500","导出数据已经超出上限");
        }
        //或取响应输出流
        try {
            ServletOutputStream out = response.getOutputStream();
            //给输入文件设置名称
            POIClass.toPackageOs(response,"待放款导出");
            //读取模板中的数据
            InputStream in = ExportUtil.toPackageIn("templates/待放款导出.xlsx");
            //根据模板的数据、把查询出来的数据给模板Sheet1组中的数据赋值、把excel输出到浏览器上
            writeDataToExcel(in,"Sheet1",daiFangKuanEntityList,out);
            if(in != null){
                in.close();
                out.close();
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //分页查询
    @Override
    public ResultVO<AllRecords> queryPage(DaiFangKuanSelectVo daiFangKuanSelectVo) {
        //查询数据
        BooleanExpression booleanExpression = Expressions.asBoolean(true).isTrue();
        if(!StringUtils.isEmpty(daiFangKuanSelectVo.getStatusName())){
            booleanExpression = booleanExpression.and(QDaiFangKuanEntity.daiFangKuanEntity.status.eq(DFKStatusEnum.getStatusValue(daiFangKuanSelectVo.getName())));
        }
        if(!StringUtils.isEmpty(daiFangKuanSelectVo.getName())){
            booleanExpression = booleanExpression.and(QDaiFangKuanEntity.daiFangKuanEntity.name.eq(daiFangKuanSelectVo.getName()));
        }
        if(daiFangKuanSelectVo.getPhone() != null){
            booleanExpression = booleanExpression.and(QDaiFangKuanEntity.daiFangKuanEntity.phone.eq(daiFangKuanSelectVo.getPhone()));
        }
        if(!StringUtils.isEmpty(daiFangKuanSelectVo.getMerchant())){
            booleanExpression = booleanExpression.and(QDaiFangKuanEntity.daiFangKuanEntity.name.eq(daiFangKuanSelectVo.getMerchant()));
        }
        Page<DaiFangKuanEntity> daiFangKuanEntityList = daiFangKuanMapper.findAll(booleanExpression,new PageRequest(daiFangKuanSelectVo.getOffset(),daiFangKuanSelectVo.getPageSize(),new Sort(Sort.Direction.DESC,"id")));
        for(DaiFangKuanEntity daiFangKuanEntity : daiFangKuanEntityList){
            daiFangKuanEntity.setStatusName(DFKStatusEnum.getStatusName(daiFangKuanEntity.getStatus()));
        }
        //查询数量
        List<DaiFangKuanEntity> size = daiFangKuanMapper.findAll();
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(daiFangKuanSelectVo.getPageIndex());
        allRecords.setPageSize(daiFangKuanSelectVo.getPageSize());
        allRecords.setTotalNumber(size.size());
        allRecords.resetTotalNumber(size.size());
        allRecords.setDataList(daiFangKuanEntityList.getContent());
        return ResultVOBuilder.success(allRecords);
    }

    //非通用方法
    private void writeDataToExcel(InputStream in, String sheet1, List<DaiFangKuanEntity> daiFangKuanEntityList, ServletOutputStream out) throws IOException {
        //POI读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheet1);
        if(sheet != null){
            //向sheet1中赋值，设置样式
            toResultListValueInfo(sheet, daiFangKuanEntityList);
        }
        //把数据写入到输出流中
        wb.write(out);
        //关闭POI方法
        wb.close();
    }

    //插入excel表中项目信息
    private void toResultListValueInfo(Sheet sheet, List<DaiFangKuanEntity> daiFangKuanEntityList) {
        //从第五行开始赋值
        int row_column = 4;
        //遍历数据集合
        Integer number = 1;
        for(DaiFangKuanEntity daiFangKuanEntity: daiFangKuanEntityList){
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            //给第一列序号赋值
            POIClass.toCellValue(row, 0, (number ++) + "");
            //给订单编号赋值
            POIClass.toCellValue(row, 1, daiFangKuanEntity.getOldNumber() + "");
            //给申请时间赋值
            POIClass.toCellValue(row, 2, daiFangKuanEntity.getCreateTime() + "");
            //给渠道赋值
            POIClass.toCellValue(row, 3, daiFangKuanEntity.getChannel() + "");
            //给申请时限赋值
            POIClass.toCellValue(row, 4, daiFangKuanEntity.getApplyTerm() + "");
            //给期供款赋值
            POIClass.toCellValue(row, 5, daiFangKuanEntity.getPeriodicContributions() + "");
            //给客户姓名赋值
            POIClass.toCellValue(row, 6, daiFangKuanEntity.getName() + "");
            //给身份证号码赋值
            POIClass.toCellValue(row, 7, daiFangKuanEntity.getIdCode() + "");
            //给资方放款金额赋值
            POIClass.toCellValue(row, 8, daiFangKuanEntity.getManagementLoanAmount() + "");
            //给互动放款金额赋值
            POIClass.toCellValue(row, 9, daiFangKuanEntity.getInteractionLoanAmount() + "");
            //给资方状态赋值
            POIClass.toCellValue(row, 10, DFKStatusEnum.getStatusName(daiFangKuanEntity.getStatus()) + "");
            //给操作赋值
            POIClass.toCellValue(row, 11, daiFangKuanEntity.getOperation() + "");
            row_column ++;
        }
    }
}
