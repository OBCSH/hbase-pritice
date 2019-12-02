package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.InsertRecord;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service("insertReord")
public class insertRecordImpl implements InsertRecord {
    @Autowired
    HbaseConfig config;
    private static Connection connection = null;
    /**
     * 插入记录（单行单列族-多列多值）
     *
     * @param tableName         表名
     * @param row               行名
     * @param columnFamilys     列族名
     * @param columns           列名（数组）
     * @param values            值（数组）（且需要和列一一对应）
     */
    @Override
    public void insertRecords(String tableName, String row, String columnFamilys, String[] columns, String[] values) throws IOException {
        TableName name = TableName.valueOf(tableName);
        Table table = connection.getTable(name);
        Put put = new Put(Bytes.toBytes(row));
        for (int i = 0; i < columns.length; i++) {
            put.addColumn(Bytes.toBytes(columnFamilys), Bytes.toBytes(columns[i]), Bytes.toBytes(values[i]));
            table.put(put);
        }
    }
    /**
     * 插入记录（单行单列族-单列单值）
     *
     * @param tableName         表名
     * @param row               行名
     * @param columnFamily      列族名
     * @param column            列名
     * @param value             值
     */
    @Override
    public void insertOneRecord(String tableName, String row, String columnFamily, String column, String value) throws IOException {
        TableName name = TableName.valueOf(tableName);
        Table table = connection.getTable(name);
        Put put = new Put(Bytes.toBytes(row));
        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
        table.put(put);
    }
}
