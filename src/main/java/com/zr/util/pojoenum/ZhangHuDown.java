package com.zr.util.pojoenum;

import lombok.Data;

/**
 * Created by 11936 on 2019/4/25.
 */

@Data
public class ZhangHuDown {
    private String label;
    private Integer value;

    public ZhangHuDown() {
    }

    public ZhangHuDown(String label, Integer value) {
        this.label = label;
        this.value = value;
    }
}
