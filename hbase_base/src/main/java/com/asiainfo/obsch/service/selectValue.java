package com.asiainfo.obsch.service;

import java.io.IOException;

public interface selectValue {
    /**
     * 查找单行单列族单列记录
     *
     * @param tablename         表名
     * @param rowKey            行名
     * @param columnFamily      列族名
     * @param column            列名
     * @return
     */
    String selectValue(String tablename, String rowKey, String columnFamily, String column) throws IOException;
}
