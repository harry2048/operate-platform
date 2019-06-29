package com.zr.earliersettlement.service.impl;

import com.zr.earliersettlement.mapper.EarliersettlementMapper;
import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.earliersettlement.service.EarliersettlementService;
import com.zr.loansituation.pojo.Riskreserve_Capitalside;
import com.zr.meiju.StatusEnum;
import com.zr.util.*;
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
 * Created by Administrator on 2019/6/21.
 */
@Service
public class EarliersettlementServiceImpl implements EarliersettlementService{
    @Autowired
    private EarliersettlementMapper earliersettlementMapper;
    @Override
    public ResultVO<List<Earliersettlement>> queryDownByearliersettlementId(Integer id) {
        if (id==null){
            return ResultVOBuilder.error("查询时ID不能为空！","500");
        }
        List<Earliersettlement> businessTypeAndManagemenList = earliersettlementMapper.queryBusinessTypeAndManagemen(id);
        return ResultVOBuilder.success(businessTypeAndManagemenList);
    }

    @Override
    public ResultVO<AllRecords> queryPage(EarliersettlementSelectVo earliersettlementSelectVo) {
        //查询数据
        List<Earliersettlement> earliersettlementList = earliersettlementMapper.queryPage(earliersettlementSelectVo);
        for (Earliersettlement earliersettlement:earliersettlementList) {
            Integer status = earliersettlement.getStatus()==true?1:0;
            earliersettlement.setStatusName(StatusEnum.getName(status));
        }
        //查询数量
        int count = earliersettlementMapper.queryCount(earliersettlementSelectVo);
        //把当前页,每一页的大小,总页数,总条数,放入到AllRecords
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(earliersettlementSelectVo.getPageIndex());
        allRecords.setPageSize(earliersettlementSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(earliersettlementList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVO queryAll() {
        List<Riskreserve_Capitalside> riskreserve_capitalsideList = earliersettlementMapper.queryAll();
        return ResultVOBuilder.success(riskreserve_capitalsideList);

    }
    /**
     *  //1.定义一个导出模板
     //2.从数据库中查询出将要导出的数据
     //3.把从数据库中查询出的数据赋值给导出模板
     //4.对需要转化的数据进行转化
     //5.在浏览器生成一个文件
     */
    @Override
    public ResultVO exportExcel(HttpServletResponse response, EarliersettlementSelectVo earliersettlementSelectVo) throws Exception {
        List<Earliersettlement> earliersettlementList = earliersettlementMapper.queryBySelectVo(earliersettlementSelectVo);
        for(Earliersettlement earliersettlement:earliersettlementList){
            earliersettlement.setStatusName(StatusEnum.getName(earliersettlement.getStatus()==true?1:0));
        }
        //限制,导出10000数据
        int totalNum = earliersettlementMapper.queryCount(earliersettlementSelectVo);
        if(totalNum>10000){
            return ResultVOBuilder.error("默认导出10000条数据","500");
        }
        //3.把从数据库中查询出的数据赋值给导出模
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "提前结清导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("templates/提前结清.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", earliersettlementList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }



    // 由于此方法不能通用, 所以单独写在这里
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<Earliersettlement> resultList, ServletOutputStream out) throws Exception {
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
    private void toResultListValueInfo(Sheet sheet, List<Earliersettlement> earliersettlementList) {
        //从第五行开始赋值
        int row_column = 4;
        int i=0;
        //遍历数据集合
        for (Earliersettlement obj : earliersettlementList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row, 0, i++ + "");
            POIClass.toCellValue(row, 1, obj.getBusinessType() + "");
            POIClass.toCellValue(row, 2, obj.getOrderNum() + "");
            POIClass.toCellValue(row, 3, obj.getSettleTime() + "");
            POIClass.toCellValue(row, 4, obj.getLoanTime()+ "");
            POIClass.toCellValue(row, 5, obj.getManagemen() + "");
            POIClass.toCellValue(row, 6, obj.getChannel()+ "");
            POIClass.toCellValue(row, 7, obj.getCustomerName()+ "");
            POIClass.toCellValue(row, 8, obj.getIdCode()+ "");
            row_column++;
        }
    }
}
