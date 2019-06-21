package com.zr.util;


import com.zr.mechant.enumall.*;
import com.zr.util.pojoenum.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 11936 on 2019/4/25.
 */

@RestController
@CrossOrigin
@RequestMapping("house")
public class PullDownUpdateConfigureMap {
    public final static String HOUSE = "mechant.mechantStatus";
    public final static String ISNO = "mechant.mechantStatus1";
    public final static String TYPE = "mechant.mechantStatus2";
    public final static String APARTMENT = "mechant.mechantStatus3";
    public final static String JIGOU = "mechant.mechantStatus4";
    public final static String KOUKUAN = "mechant.mechantStatus5";

    @PostMapping("getPullDownStatusList")
    @CrossOrigin
    public ResultVO getPullDownList(@RequestBody List<String> methodKey){
        //放入本地所有的下拉列表的key
        List<String> pullKey = new ArrayList<>();
        pullKey.add(HOUSE);
        pullKey.add(ISNO);
        pullKey.add(TYPE);
        pullKey.add(APARTMENT);
        pullKey.add(JIGOU);
        pullKey.add(KOUKUAN);

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
        if(pullKey.contains(HOUSE)){
            List<HouseDown> newList = new ArrayList<>();
            for (int i = HouseEnum.values().length-1; i >= 0; i--){
                newList.add(new HouseDown(HouseEnum.getHouseName(i), i));
            }
            hashMap.put(HOUSE, newList);
        }


        if(pullKey.contains(ISNO)){
            List<IsNoDown> newList = new ArrayList<>();
            for (int i = IsNoEnum.values().length-1; i >= 0; i--){
                newList.add(new IsNoDown(IsNoEnum.getIsNoName(i), i));
            }
            hashMap.put(ISNO, newList);
        }

        if(pullKey.contains(TYPE)){
            List<TypeDown> newList = new ArrayList<>();
            for (int i = TypeEnum.values().length-1; i >= 0; i--){
                newList.add(new TypeDown(TypeEnum.getTypeName(i), i));
            }
            hashMap.put(TYPE, newList);
        }

        if(pullKey.contains(APARTMENT)){
            List<ApartmentDown> newList = new ArrayList<>();
            for (int i = ApartmentEnum.values().length-1; i >= 0; i--){
                newList.add(new ApartmentDown(ApartmentEnum.getApartmentName(i), i));
            }
            hashMap.put(APARTMENT, newList);
        }

        if(pullKey.contains(JIGOU)){
            List<JiGouDown> newList = new ArrayList<>();
            for (int i = JiGouEnum.values().length-1; i >= 0; i--){
                newList.add(new JiGouDown(JiGouEnum.getJiGouName(i), i));
            }
            hashMap.put(JIGOU, newList);
        }

        if(pullKey.contains(KOUKUAN)){
            List<KouKuanDown> newList = new ArrayList<>();
            for (int i = KouKuanEnum.values().length-1; i >= 0; i--){
                newList.add(new KouKuanDown(KouKuanEnum.getKouKuanName(i), i));
            }
            hashMap.put(KOUKUAN, newList);
        }





        return hashMap;
    }


}
