package com.zr.xinshenstatistics.service.impl;


import com.zr.xinshenstatistics.mapper.XinshenstatisticsMapper;
import com.zr.xinshenstatistics.pojo.Funding;
import com.zr.xinshenstatistics.pojo.Xinshenstatistics;
import com.zr.xinshenstatistics.pojo.XinshenstatisticsVO;
import com.zr.xinshenstatistics.service.XinshenstatisticsService;
import com.zr.xinshenstatistics.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 86151 on 2019/6/14.
 */
@Service
@Slf4j
public class XinshenstatisticsServiceImpl implements XinshenstatisticsService {
    @Autowired
    private XinshenstatisticsMapper xinshenstatisticsMapper;

    @Override
    @Transactional
    public ResultVo<AllRecords> queryPage(XinshenstatisticsVO xinshenstatisticsVO) {
        //查询数据
        List<Xinshenstatistics> xinshenstatisticsList = xinshenstatisticsMapper.queryPage(xinshenstatisticsVO);

        //查询数量
        int count = xinshenstatisticsMapper.queryCount(xinshenstatisticsVO);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(xinshenstatisticsVO.getPageIndex());
        allRecords.setPageSize(xinshenstatisticsVO.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(xinshenstatisticsList);
        return ResultBuildVo.success(allRecords);
    }
    /**
     *  //1.定义一个导出模板
     //2.从数据库中查询出将要导出的数据
     //3.把从数据库中查询出的数据赋值给导出模板
     //4.对需要转化的数据进行转化
     //5.在浏览器生成一个文件
     */
    @Override
    public ResultVo exportExcel(HttpServletResponse response, XinshenstatisticsVO xinshenstatisticsVO) throws Exception {
        List<Xinshenstatistics> xinshenstatisticsList = xinshenstatisticsMapper.queryBySelectVo(xinshenstatisticsVO);
        System.out.println("长度"+xinshenstatisticsList.size());

        //限制,导出10000数据
        int totalNum = xinshenstatisticsMapper.queryCount(xinshenstatisticsVO);
        if(totalNum>10000){
            return ResultBuildVo.error("默认导出10000条数据","500");
        }
        //3.把从数据库中查询出的数据赋值给导出模
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "提前结清导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/提前结清.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", xinshenstatisticsList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }

    @Override
    public ResultVo queryById(Integer id) {
        if (id==null){
            return ResultBuildVo.error("查看时id不能为空！","500");
        }
        Funding funding = xinshenstatisticsMapper.queryById(id);
        if (funding==null){
            return ResultBuildVo.error("查看对象不存在！","500");
        }
        return ResultBuildVo.success(funding);
    }

    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<Xinshenstatistics> resultList, ServletOutputStream out) throws Exception {
        //POi读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            //向sheet1中赋值，设置样式
            toResultListValueInfo( sheet, resultList);
        }
        //把数据写入到输出流中
        wb.write(out);
        //关闭poi方法
        wb.close();
    }

    /**
     * 插入excel表中项目信息
     *
     * @param sheet
     */
    private void toResultListValueInfo(Sheet sheet, List<Xinshenstatistics> earliersettlementList) {
        //从第五行开始赋值
        int row_column = 4;
        int i = 0;
        //遍历数据集合
        for (Xinshenstatistics obj : earliersettlementList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row, 0, i++ + "");
            POIClass.toCellValue(row, 1, obj.getScopeOfBusiness() + "");
            POIClass.toCellValue(row, 2, obj.getOrderNum() + "");
            POIClass.toCellValue(row, 4, obj.getLoanTime() + "");
            POIClass.toCellValue(row, 5, obj.getManagemen() + "");
            POIClass.toCellValue(row, 6, obj.getChannel() + "");
            POIClass.toCellValue(row, 7, obj.getCustomerName() + "");
            POIClass.toCellValue(row, 8, obj.getIdCode() + "");
            row_column++;
        }

    }
}
