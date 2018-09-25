package com.dept.common.utils;

import java.io.Serializable;

/**
 * @author WH1707008
 * @date 2018/8/30 12:12
 * Description:
 */
public class ScanPool implements Serializable {
    /**创建时间*/
    private Long createTime = System.currentTimeMillis();

    public Long getCreateTime() {
        return createTime;
    }
}
