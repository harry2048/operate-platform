package com.zr.lendinglist.service.impl;

import com.zr.lendinglist.mapper.LendingListMapper;
import com.zr.lendinglist.model.LendingListSelectVo;
import com.zr.lendinglist.model.LendingList;
import com.zr.lendinglist.service.LendingListService;
import com.zr.util.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/21.
 */
@Service
public class LendingListServiceImpl implements LendingListService {

    @Autowired
    private LendingListMapper lendingListMapper;

    /**
     * 查看
     * @param id
     * @return
     */
    @Override
    public ResultVO querylendinglistById(Integer id) {
        LendingList lendingList = lendingListMapper.querylendinglistById(id);
        if (lendingList==null){
            return ResultVOBuilder.error("查看对象不存在！","500");
        }
        return ResultVOBuilder.success(lendingList);
    }

    /**
     * 分页查看
     * @param lendingListSelectVo
     * @return
     */
    @Override
    public ResultVO<AllRecords> queryPage(LendingListSelectVo lendingListSelectVo) {
        //查询数据
        List<LendingList> lendingListList = lendingListMapper.queryPage(lendingListSelectVo);
        //查询数量
        int count =  lendingListMapper.queryCount(lendingListSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(lendingListSelectVo.getPageIndex());
        allRecords.setPageSize(lendingListSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(lendingListList);
        return ResultVOBuilder.success(allRecords);
    }

    /**
     * 导出
     * @param response
     * @param lendingListSelectVo
     * @return
     * @throws Exception
     */

    @Override
    public ResultVO exportExcel(HttpServletResponse response, LendingListSelectVo lendingListSelectVo) throws Exception {
        //从数据库中查询出将要导出的数据
        List<LendingList> lendingListList = lendingListMapper.queryBySelectVo(lendingListSelectVo);
        //限制，默认只允许导出10000条数据
        int count = lendingListMapper.queryCount(lendingListSelectVo);
        if (count>10000){
            return ResultVOBuilder.error("默认只允许导出10000条数据！请增加条件导出","500");
        }
        //获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response, "已放款查询导出");
        //读取模板中的数据
        InputStream in = ExportUtil.toPackageIn("daochu/已放款查询.xlsx");
        //根据模板的数据、把查询出来的数据给摸版SHeet1组中的数据赋值、把excel输出到浏览器上
        writeDataToExcel(in, "Sheet1", lendingListList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return null;
    }
    private void writeDataToExcel(InputStream in, String sheetName,
                                  List<LendingList> resultList, ServletOutputStream out) throws Exception {
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
    private void toResultListValueInfox(Sheet sheet, List<LendingList> lendingListList) {
        //从第五行开始赋值
        int row_column = 4;
        int num = 1;
        //遍历数据集合
        for (LendingList obj : lendingListList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给序号赋值
            POIClass.toCellValue(row,0, num++ + "");
            // 给资金方赋值
            POIClass.toCellValue(row, 1, obj.getFundingParty() + "");
            // 给商户赋值
            POIClass.toCellValue(row, 2, obj.getMerchant() + "");
            // 给客户姓名赋值
            POIClass.toCellValue(row, 3, obj.getCustomerName() + "");
            //给身份证号码赋值
            POIClass.toCellValue(row, 4, obj.getIdCode() + "");
            //给申请时间赋值
            POIClass.toCellValue(row, 5, obj.getApplyTime() + "");
            //给审核时间赋值
            POIClass.toCellValue(row, 6, obj.getExamineTime() + "");
            //给放款日期赋值
            POIClass.toCellValue(row, 7, obj.getLendingTime() + "");
            //给申请金额赋值
            POIClass.toCellValue(row, 8, obj.getApplyAmount() + "");
            //给申请期限赋值
            POIClass.toCellValue(row, 9, obj.getApplyTerm() + "");
            //给贴息方式赋值
            POIClass.toCellValue(row, 10, obj.getDiscountMode() + "");
            //给宽限期赋值
            POIClass.toCellValue(row, 11, obj.getGraceperiod() + "");
            //给期供款赋值
            POIClass.toCellValue(row, 12, obj.getPeriodicContributions() + "");
            //给资方放款金额赋值
            POIClass.toCellValue(row, 13, obj.getManagementLoanAmount() + "");
            //给贷鱼放款金额赋值
            POIClass.toCellValue(row, 14, obj.getDaiyuLoanAmount() + "");
            //给贷款状态
            POIClass.toCellValue(row, 15, obj.getLoanStatus() + "");
            row_column++;
        }
    }

}
