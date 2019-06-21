package com.zr.util.pojoenum;


import com.zr.mechant.enumall.ZhangHuEnum;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 11936 on 2019/4/25.
 */

@RestController
@CrossOrigin
@RequestMapping("zhanghu")
public class PullDownZhangHuMap {
    public final static String ZHANGHU= "mechant.mechantStatus111";


    @PostMapping("getPullDownStatusList")
    @CrossOrigin
    public ResultVO getPullDownList(@RequestBody List<String> methodKey){
        //放入本地所有的下拉列表的key
        List<String> pullKey = new ArrayList<>();
        pullKey.add(ZHANGHU);
        //去工厂里找我需要的下拉列表
        HashMap<String, List> hashMap =  getAddKey(pullKey);
        //常见一个新的hashMap
        HashMap<String, List> newHashMap = new HashMap<>();

        //将需要的下拉列表赋值给新的newHashMap
        for (String s : methodKey){
            if(hashMap.containsKey(s)){
                newHashMap.put(s, hashMap.get(s));
            }
        }
        return ResultVOBuilder.success(newHashMap);
    }

    private HashMap<String,List> getAddKey(List<String> pullKey) {
        HashMap<String, List> hashMap = new HashMap<>();
        if(pullKey.contains(ZHANGHU)){
            List<ZhangHuDown> newList = new ArrayList<>();
            for (int i = ZhangHuEnum.values().length-1; i >= 0; i--){
                newList.add(new ZhangHuDown(ZhangHuEnum.getZhangHuName(i), i));
            }
            hashMap.put(ZHANGHU, newList);
        }
        return hashMap;
    }

}
