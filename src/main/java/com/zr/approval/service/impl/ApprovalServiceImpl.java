package com.zr.approval.service.impl;

import com.zr.approval.approvalEnum.IsApprovalEnum;
import com.zr.approval.approvalEnum.StatusEnmu;
import com.zr.approval.mapper.ApprovalByPageMapper;
import com.zr.approval.pojo.Approval;
import com.zr.approval.pojo.ApprovalSelectVo;
import com.zr.approval.service.ApprovalService;
import com.zr.util.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Administrator on 2019/6/21 0021.
 */
@Service
public class ApprovalServiceImpl implements ApprovalService{


    @Autowired
    private ApprovalByPageMapper approvalByPageMapper;


//////////////////////////////分页查询//////////////////////////////////////////////////////
    @Override
    public ResultVO<AllRecords> queryByPage(ApprovalSelectVo approvalSelectVo) {
        //先查询出来总的条数
        int count=approvalByPageMapper.queryCount();
        //在查询出来所有的信息
        List<ApprovalSelectVo> approvalList = approvalByPageMapper.queryByPage(approvalSelectVo);
        //封装类进行数字和字符转换
        List<ApprovalSelectVo> approvalSelectVos = numberToString(approvalList);

        //带入分页信息
        AllRecords records=new AllRecords();
        records.setTotalNumber(count);
        records.setPageSize(approvalSelectVo.getPageSize());
        records.setPageIndex(approvalSelectVo.getPageIndex());
        records.setDataList(approvalSelectVos);
        records.resetTotalNumber(count);

        return ResultVOBuilder.success(records);
    }

///////////////////////////////////导出/////////////////////////////////////////////////////
    @Override
    public ResultVO exportExcel(HttpServletResponse response, List<ApprovalSelectVo> approvalSelectVoList) throws Exception{
        //根据id查询出数据库中的全部数据 并存入集合中
        List<ApprovalSelectVo> selectVoList=new ArrayList<>();
        for (ApprovalSelectVo app:approvalSelectVoList){
            Approval byid = approvalByPageMapper.findById(app.getId());
            ApprovalSelectVo approvalSelectVo=new ApprovalSelectVo();
            BeanUtils.copyProperties(byid,approvalSelectVo);
            selectVoList.add(approvalSelectVo);
        }
        //用枚举类进行字符转换
        List<ApprovalSelectVo> exList = numberToString(selectVoList);
        //限制导出的最大上限
        int count=approvalByPageMapper.queryCount();
        if(count>10000){
            return ResultVOBuilder.error("最多只能导出10000条数据","500");
        }
        //开始导出 ，获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //给输出文件设置名称
        POIClass.toPackageOs(response,"批扣列表副本");
        //读取模板中的数据
        InputStream inputStream = ExportUtil.toPackageIn("templates/批扣列表模板.xlsx");
        //根据模板中的数据格式将查询出来的数据填入模板，并将有数据的excel文件传输给浏览器
        writeDataToExcel(inputStream, "Sheet1", exList, outputStream);
        if(inputStream!=null){
            inputStream.close();
            outputStream.close();
        }

        return null;
    }

    private void writeDataToExcel(InputStream inputStream, String sheet1, List<ApprovalSelectVo> selectVoList, ServletOutputStream outputStream)throws Exception {
        //poi读取模板
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        //读取sheet中的数据
        XSSFSheet sheet = wb.getSheet(sheet1);
        //向sheet中赋值
        if(sheet!=null){
            toResultListValueInfo(sheet,selectVoList);//调用封装方法去赋值
        }
        //将数据写入输出流中
        wb.write(outputStream);
        //关闭流
        wb.close();


    }
    private void toResultListValueInfo(Sheet sheet, List<ApprovalSelectVo> appList) {
        //从第五行开始赋值
        int row_column = 4;
        //遍历数据集合
        for (ApprovalSelectVo obj : appList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, obj.getId() + "");
            // 给第二列生成日期赋值
            POIClass.toCellValue(row, 1, obj.getCreateTime() + "");
            // 给第3列合同编号赋值
            POIClass.toCellValue(row, 2, obj.getLoanContractNum() + "");
            // 给客户名称赋值
            POIClass.toCellValue(row, 3, obj.getCustomerName() + "");
            //给证件号赋值
            POIClass.toCellValue(row, 4, obj.getIdCode() + "");
            //给应扣款赋值
            POIClass.toCellValue(row, 5, obj.getDeductible() + "");
            //给开户行赋值
            POIClass.toCellValue(row, 6, obj.getReimbursementAccountOpeningBank() + "");
            //给还款账号赋值
            POIClass.toCellValue(row, 7, obj.getPaymentAccount() + "");
            //给发出代扣时间赋值
            POIClass.toCellValue(row, 8, obj.getUpdateTime()+ "");//随意赋值  注意修改
            //给扣款状态赋值
            POIClass.toCellValue(row, 9, obj.getStatusName() + "");
            //给扣款结果赋值
            POIClass.toCellValue(row, 10, obj.getDeductionResults() + "");

            row_column++;
        }
    }

    //数字转换成字符类
    public List<ApprovalSelectVo> numberToString(List<ApprovalSelectVo> approvalList){
        //遍历集合 进行数值和字符转换
        for (ApprovalSelectVo ap:approvalList){
            if(ap.getStatus()!=null){
               ap.setStatusName(StatusEnmu.getstatusName(ap.getStatus()));
            }
            if(ap.getIsApproval()!=null){
               ap.setIsApprovalName(IsApprovalEnum.getisApprovalName(ap.getIsApproval()));
            }
        }

        return approvalList;
    }









}
