package com.zr.util.pojoenum;

import lombok.Data;

/**
 * Created by 11936 on 2019/4/25.
 */

@Data
public class StatusDown {
    private String label;
    private Integer value;

    public StatusDown() {
    }

    public StatusDown(String label, Integer value) {
        this.label = label;
        this.value = value;
    }
}
