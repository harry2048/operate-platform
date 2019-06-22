package com.zr.sourceofinput.service.impl;

import com.zr.sourceofinput.mapper.SourceofinputMapper;
import com.zr.sourceofinput.pojo.Sourceofinput;
import com.zr.sourceofinput.pojo.SourceofinputSelectVo;
import com.zr.sourceofinput.service.SourceofinputService;
import com.zr.util.AllRecords;
import com.zr.util.ExportUtil;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.pojoenum.POIClass;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@Service
public class SourceofinputServiceImpl implements SourceofinputService {

    @Autowired
    private SourceofinputMapper sourceofinputMapper;
    @Override
    public ResultVO<AllRecords> queryPage(SourceofinputSelectVo sourceofinputSelectVo) {

        List<Sourceofinput> sourceofinputList = sourceofinputMapper.queryPage(sourceofinputSelectVo);
        //查询数量
        int count = sourceofinputMapper.queryCount(sourceofinputSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(sourceofinputSelectVo.getPageIndex());
        allRecords.setPageSize(sourceofinputSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(sourceofinputList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVO<Sourceofinput> querySourceofinputById(Integer id) {
        if (id == null) {
            return ResultVOBuilder.error("查看时id不能为空！", "500");
        }
        Sourceofinput sourceofinput = sourceofinputMapper.queryById(id);
        if (sourceofinput == null) {
            return ResultVOBuilder.error("查看对象不存在！", "500");
        }
        return ResultVOBuilder.success(sourceofinput);
    }

    @Override
    public ResultVO exportExcel(HttpServletResponse response, SourceofinputSelectVo sourceofinputSelectVo) throws Exception {
        //从数据库中查询出将要导出的数据
        List<Sourceofinput> sourceofinputList = sourceofinputMapper.queryBySelectVo(sourceofinputSelectVo);
        //限制，默认只允许导出10000条数据
        int count = sourceofinputMapper.queryCount(sourceofinputSelectVo);
        if (count>10000){
            return ResultVOBuilder.error("默认只允许导出10000条数据！请增加条件导出","500");
        }
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "进件来源导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/进件来源.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", sourceofinputList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<Sourceofinput> resultList, ServletOutputStream out) throws Exception {
        //POi读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            //向sheet1中赋值，设置样式
            toResultListValueInfox( sheet, resultList);
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
    private void toResultListValueInfox(Sheet sheet, List<Sourceofinput> sourceofinputList) {
        //从第五行开始赋值
        int row_column = 4;
        int num = 1;
        //遍历数据集合
        for (Sourceofinput obj : sourceofinputList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, num++ + "");
            // 给第二列订单编号赋值
            POIClass.toCellValue(row, 1, obj.getOrderNum() + "");
            // 给第3列商户名称赋值
            POIClass.toCellValue(row, 2, obj.getMerchant() + "");
            // 给客户名称赋值
            POIClass.toCellValue(row, 3, obj.getCustomerName() + "");
            //给身份证号码赋值
            POIClass.toCellValue(row, 4, obj.getIdCode() + "");
            //给进件时间赋值
            POIClass.toCellValue(row, 5, obj.getIncomingPartsTime() + "");
            //给进件省份赋值
            POIClass.toCellValue(row, 6, obj.getIncomingPartsProvince() + "");
            //给进件城市赋值
            POIClass.toCellValue(row, 7, obj.getIncomingPartsCity() + "");
            //给地址赋值
            POIClass.toCellValue(row, 8, obj.getSpecificAddress() + "");
            row_column++;
        }
    }
}
