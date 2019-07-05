package com.zr.xinshendaily.service.impl;

import com.zr.util.*;
import com.zr.xinshendaily.mapper.CreditDailyMapper;
import com.zr.xinshendaily.pojo.CapitalSelectVo;
import com.zr.xinshendaily.pojo.TenantSelectVo;
import com.zr.xinshendaily.pojo.Xinshendaily;
import com.zr.xinshendaily.service.CreditDailyService;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 94818 on 2019/6/21.
 */
@Service
public class CreditDailyServiceImpl implements CreditDailyService{

    @Autowired
    private CreditDailyMapper creditDailyMapper;
    @Override
    public ResultVO<AllRecords> queryPage(CapitalSelectVo capitalSelectVo) {

        capitalSelectVo.setTypeName("资方日报表");
        //查询数据
        List<Xinshendaily> xinshendailyList = creditDailyMapper.queryPage(capitalSelectVo);
        //查询数量
        int count =  creditDailyMapper.queryCount(capitalSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(capitalSelectVo.getPageIndex());
        allRecords.setPageSize(capitalSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(xinshendailyList);
        return ResultVOBuilder.success(allRecords);
    }

    /**
     *  资方日报表导出
     //1.定义一个导出模板
     //2.从数据库中查询出将要导出的数据
     //3.把从数据库中查询出的数据赋值给导出模板
     //4.对需要转化的数据进行转化
     //5.在浏览器生成一个文件
     */
    @Override
    public ResultVO exportExcel(HttpServletResponse resp, CapitalSelectVo capitalSelectVo) throws Exception {
        capitalSelectVo.setTypeName("资方日报表");

        //从数据库中查询出将要导出的数据
        List<Xinshendaily> xinshendailyList = creditDailyMapper.queryBySelectVo(capitalSelectVo);

        //限制，默认只允许导出10000条数据
        int count = creditDailyMapper.queryCount(capitalSelectVo);
        if (count > 10000) {
            return ResultVOBuilder.error("500", "默认只允许导出10000条数据！请增加条件导出");
        }
        //获取响应输出流
        ServletOutputStream out = resp.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(resp, "资方日报表");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/资方日报表.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", xinshendailyList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;

    }

    @Override
    public ResultVO<AllRecords> queryTenantPage(TenantSelectVo tenantSelectVo) {
        tenantSelectVo.setTypeName("商户日报表");
        //查询数据
        List<Xinshendaily> xinshendailyList = creditDailyMapper.queryTenantPage(tenantSelectVo);
        //查询数量
        int count =  creditDailyMapper.queryTenantCount(tenantSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(tenantSelectVo.getPageIndex());
        allRecords.setPageSize(tenantSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(xinshendailyList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVO exportTenantExcel(HttpServletResponse resp, TenantSelectVo tenantSelectVo) throws Exception {
        tenantSelectVo.setTypeName("商户日报表");

        //从数据库中查询出将要导出的数据
        List<Xinshendaily> xinshendailyList = creditDailyMapper.queryByTenantSelectVo(tenantSelectVo);

        //限制，默认只允许导出10000条数据
        int count = creditDailyMapper.queryTenantCount(tenantSelectVo);
        if (count > 10000) {
            return ResultVOBuilder.error("500", "默认只允许导出10000条数据！请增加条件导出");
        }
        //获取响应输出流
        ServletOutputStream out = resp.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(resp, "商户日报表");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("商户日报表.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", xinshendailyList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;

    }

    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<Xinshendaily> resultList, ServletOutputStream out) throws Exception {
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
    private void toResultListValueInfo(Sheet sheet, List<Xinshendaily> xinshenList) {
        //从第五行开始赋值
        int row_column = 5;
        int i=0;
        //遍历数据集合
        for (Xinshendaily obj : xinshenList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, i++ + "");
            // 给第二列编码赋值商户名称
            POIClass.toCellValue(row, 1, obj.getMerchant() + "");
            // 给第3列名称赋值通过金额
            POIClass.toCellValue(row, 2, obj.getPassAmount() + "");
            // 给审批总数赋值
            POIClass.toCellValue(row, 3, obj.getShenPiNum() + "");
            //给通过数量赋值
            POIClass.toCellValue(row, 4, obj.getPassNum() + "");
            // 给拒绝数量赋值
            POIClass.toCellValue(row, 5, obj.getJuJueNum() + "");
            // 给打回数量赋值
            POIClass.toCellValue(row, 6, obj.getDahuiNum() + "");
            // 给取消数量赋值
            POIClass.toCellValue(row, 7, obj.getQuXiaoNum() + "");
            //给通过率赋值
            POIClass.toCellValue(row, 8, obj.getTongGuoLu() + "");
            //给金额比例赋值
            POIClass.toCellValue(row, 9, obj.getAmountBiLi() + "");
            row_column++;
        }
    }
}
