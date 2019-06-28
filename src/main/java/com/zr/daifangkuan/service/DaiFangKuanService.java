package com.zr.daifangkuan.service;

import com.zr.daifangkuan.entity.DaiFangKuanSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:32
 */
public interface DaiFangKuanService {
    //导出
    ResultVO exportDFK(HttpServletResponse response, DaiFangKuanSelectVo daiFangKuanSelectVo);

    //分页
    ResultVO<AllRecords> queryPage(DaiFangKuanSelectVo daiFangKuanSelectVo);
}
