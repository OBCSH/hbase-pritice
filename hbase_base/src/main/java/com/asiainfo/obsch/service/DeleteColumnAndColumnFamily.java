package com.asiainfo.obsch.service;

import java.io.IOException;

public interface DeleteColumnAndColumnFamily {
    /**
     * 删除单行单列族单列记录
     *
     * @param tablename         表名
     * @param rowkey            行名
     * @param columnFamily      列族名
     * @param column            列名
     */
    void deleteColumn(String tablename, String rowkey, String columnFamily, String column) throws IOException;
    /**
     * 删除单行单列族记录
     * @param tablename         表名
     * @param rowkey            行名
     * @param columnFamily      列族名
     */
    void deleteColumnFamily(String tablename, String rowkey, String columnFamily) throws IOException;
}
