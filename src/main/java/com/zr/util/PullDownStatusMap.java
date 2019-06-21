package com.zr.util;


import com.zr.mechant.enumall.StatusEnum;
import com.zr.util.pojoenum.StatusDown;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 11936 on 2019/4/25.
 */

@RestController
@CrossOrigin
@RequestMapping("iwm")
public class PullDownStatusMap {
    public final static String SUBCLASSSTATUS = "mechant.mechantStatus";


    @PostMapping("getPullDownStatusList")
    @CrossOrigin
    public ResultVO getPullDownList(@RequestBody List<String> methodKey){
        //放入本地所有的下拉列表的key
        List<String> pullKey = new ArrayList<>();
        pullKey.add(SUBCLASSSTATUS);
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
        if(pullKey.contains(SUBCLASSSTATUS)){
            List<StatusDown> newList = new ArrayList<>();
            for (int i = StatusEnum.values().length-1; i >= 0; i--){
                newList.add(new StatusDown(StatusEnum.getStatusName(i), i));
            }
            hashMap.put(SUBCLASSSTATUS, newList);
        }
        return hashMap;
    }

}
