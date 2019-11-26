package com.asiainfo.obsch.service;

import java.io.IOException;

public interface selectAndDeleteRow {
    /**
     * 查找一行记录
     *
     * @param tablename         表名
     * @param rowKey            行名
     */
    String selectRow(String tablename, String rowKey) throws IOException;
    /**
     * 删除一行记录
     *
     * @param tablename         表名
     * @param rowkey            行名
     */
    void deleteRow(String tablename, String rowkey) throws IOException;
}
