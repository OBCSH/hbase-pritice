package com.asiainfo.obsch.service;

import java.io.IOException;

public interface insertRecord {
    /**
     * 插入记录（单行单列族-多列多值）
     *
     * @param tableName         表名
     * @param row               行名
     * @param columnFamilys     列族名
     * @param columns           列名（数组）
     * @param values            值（数组）（且需要和列一一对应）
     */
    void insertRecords(String tableName, String row, String columnFamilys, String[] columns, String[] values) throws IOException;
    /**
     * 插入记录（单行单列族-单列单值）
     *
     * @param tableName         表名
     * @param row               行名
     * @param columnFamily      列族名
     * @param column            列名
     * @param value             值
     */
    void insertOneRecord(String tableName, String row, String columnFamily, String column, String value) throws IOException;
}
