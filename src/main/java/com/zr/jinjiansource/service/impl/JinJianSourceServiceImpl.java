package com.zr.jinjiansource.service.impl;

import com.zr.jinjiansource.dto.JinJianSourceOutputVo;
import com.zr.jinjiansource.dto.JinJianSourceSelectVo;
import com.zr.jinjiansource.mapper.JinJianSourceMapper;
import com.zr.jinjiansource.pojo.JinJianSource;
import com.zr.jinjiansource.service.JinJianSourceService;
import com.zr.mechant.enumall.StatusEnum;
import com.zr.util.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class JinJianSourceServiceImpl implements JinJianSourceService {
    @Autowired
    private JinJianSourceMapper jinJianSourceMapper;


    @Override
    public ResultVO queryPage(JinJianSourceSelectVo jinJianSourceSelectVo) {
        if (jinJianSourceSelectVo.getPageIndex() == 0) {
            return ResultVOBuilder.error("500", "当前页不能为空");
        } else if (jinJianSourceSelectVo.getPageSize() == 0) {
            return ResultVOBuilder.error("500", "每页记录数不能为空");
        }

        //查询数据
        List<JinJianSource> jinJianSourceList = jinJianSourceMapper.queryPage(jinJianSourceSelectVo);
        //查询数量
        int count = jinJianSourceMapper.queryCount(jinJianSourceSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(jinJianSourceSelectVo.getPageIndex());
        allRecords.setPageSize(jinJianSourceSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(jinJianSourceList);
        return ResultVOBuilder.success(allRecords);
    }

    /**
     * 导出
     * //1.定义一个导出模板
     * //2.从数据库中查询出将要导出的数据
     * //3.把从数据库中查询出的数据赋值给导出模板
     * //4.对需要转化的数据进行转化
     * //5.在浏览器生成一个文件
     */
    @Override
    public ResultVO exportExcel(HttpServletResponse response, JinJianSourceOutputVo jianSourceOutputVo) throws Exception {
        //从数据库中查询出将要导出的数据
        List<JinJianSourceOutputVo> jianSourceOutputVoList = jinJianSourceMapper.queryByJinJianSourceOutputVo(jianSourceOutputVo);

        // 处理状态为1或0
        /*for (JinJianSourceOutputVo outputVo:jianSourceOutputVoList){
            outputVo.setStatusName(StatusEnum.getMessage(outputVo.getStatus()));
        }*/
        //限制，默认只允许导出10000条数据
        int count = jinJianSourceMapper.queryCountByJinJianSourceOutputVo(jianSourceOutputVo);
        if (count > 10000) {
            return ResultVOBuilder.error("500", "默认只允许导出10000条数据！请增加条件导出");
        }
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "进件来源导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/进件来源导出.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel2(in, "Sheet1", jianSourceOutputVoList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }

    // 由于此方法不能通用, 所以单独写在这里
    public void writeDataToExcel2(InputStream in, String sheetName, List<JinJianSourceOutputVo> jianSourceOutputVoList, ServletOutputStream out) throws Exception {
        //POi读取模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            //向sheet1中赋值，设置样式
            toResultListValueInfo(sheet, jianSourceOutputVoList);
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
    private void toResultListValueInfo(Sheet sheet, List<JinJianSourceOutputVo> jianSourceOutputVoList) {
        //从第五行开始赋值
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int row_column = 4;
        int rowNum = 1;
        //遍历数据集合
        for (JinJianSourceOutputVo obj : jianSourceOutputVoList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row, 0, rowNum++ + "");
            // 给第2列序号赋值赋值
            POIClass.toCellValue(row, 1, obj.getOrderNum() + "");
            // 给第3列编码赋值
            POIClass.toCellValue(row, 2, obj.getMerchant() + "");
            // 给第4列名称赋值
            POIClass.toCellValue(row, 3, obj.getCustomerName() + "");
            // 给第5列名称赋值
            POIClass.toCellValue(row, 4, obj.getIdCode() + "");
            //给第6列名称赋值
            String format = sdf.format(obj.getIncomingPartsTime());
            POIClass.toCellValue(row, 5, format + "");
            //给第7列名称赋值
            POIClass.toCellValue(row, 6, obj.getIncomingPartsProvince() + "");
            //给第8列名称赋值
            POIClass.toCellValue(row, 7, obj.getIncomingPartsCity() + "");
            //给第9列名称赋值
            POIClass.toCellValue(row, 8, obj.getSpecificAddress() + "");
            row_column++;
        }
    }
}
