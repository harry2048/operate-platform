package com.zr.jinjiansource.controller;

import com.zr.jinjiansource.dto.JinJianSourceOutputVo;
import com.zr.jinjiansource.dto.JinJianSourceSelectVo;
import com.zr.jinjiansource.service.JinJianSourceService;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/jinjiansource")
public class JinJianSourceController {

    @Autowired
    private JinJianSourceService jinJianSourceService;

    /**
     * 按条件分页查询
     * @param jinJianSourceSelectVo
     * @return
     */
    @PostMapping("/queryBySelect")
    public ResultVO queryPage(@RequestBody JinJianSourceSelectVo jinJianSourceSelectVo) {
        return jinJianSourceService.queryPage(jinJianSourceSelectVo);
    }

    //导出
    //1.定义一个导出模板
    //2.从数据库中查询出将要导出的数据
    //3.把从数据库中查询出的数据赋值给导出模板
    //4.对需要转化的数据进行转化
    //5.在浏览器生成一个文件
    @GetMapping("/exportExcel")
    public ResultVO exportExcel(HttpServletResponse resp, String merchant, String customerName, String orderNum, String idCode, Date incomingPartsTime, String incomingPartsProvince, String incomingPartsCity, String specificAddress) throws Exception{
        JinJianSourceOutputVo jianSourceOutputVo = new JinJianSourceOutputVo(merchant, customerName, orderNum, idCode, incomingPartsTime, incomingPartsProvince, incomingPartsCity, specificAddress);
        return jinJianSourceService.exportExcel(resp, jianSourceOutputVo);
    }
}