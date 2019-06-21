package com.zr.util.pojoenum;

import lombok.Data;

/**
 * Created by 11936 on 2019/4/25.
 */

@Data
public class HouseDown {
    private String label;
    private Integer value;

    public HouseDown() {
    }

    public HouseDown(String label, Integer value) {
        this.label = label;
        this.value = value;
    }
}
