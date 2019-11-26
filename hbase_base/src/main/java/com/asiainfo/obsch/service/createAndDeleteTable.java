package com.asiainfo.obsch.service;

import java.io.IOException;

public interface createAndDeleteTable {
    /**
     * 增加表操作
     *
     * @param tablename
     */
    void createTable(String tablename, String[] columnFamily) throws IOException;
    /**
     * 删除表操作
     *
     * @param tablename
     */
    void deleteTable(String tablename) throws IOException;
}
