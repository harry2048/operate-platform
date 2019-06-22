package com.zr;

import com.zr.pikouflowingwater.dto.PiKouFlowingWaterSelectVo;
import com.zr.pikouflowingwater.mapper.PiKouFlowingWaterMapper;
import com.zr.pikouflowingwater.service.PiKouFlowingWaterService;
import com.zr.util.ResultVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperatePlatformApplicationTests {

	@Autowired
	private PiKouFlowingWaterService piKouFlowingWaterService;
	@Test
	public void contextLoads() {
		PiKouFlowingWaterSelectVo piKouFlowingWaterSelectVo = new PiKouFlowingWaterSelectVo();
		piKouFlowingWaterSelectVo.setPageIndex(1);
		piKouFlowingWaterSelectVo.setPageSize(3);
		ResultVO resultVO = piKouFlowingWaterService.queryPage(piKouFlowingWaterSelectVo);

		System.out.println(resultVO);
	}

}
