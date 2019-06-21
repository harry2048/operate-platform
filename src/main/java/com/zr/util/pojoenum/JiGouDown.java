package com.zr.util.pojoenum;

import lombok.Data;

/**
 * Created by 11936 on 2019/4/25.
 */

@Data
public class JiGouDown {
    private String label;
    private Integer value;

    public JiGouDown() {
    }

    public JiGouDown(String label, Integer value) {
        this.label = label;
        this.value = value;
    }
}
