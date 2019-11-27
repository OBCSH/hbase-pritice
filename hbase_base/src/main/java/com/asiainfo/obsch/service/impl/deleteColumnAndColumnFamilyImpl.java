package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.deleteColumnAndColumnFamily;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;



@Service("deleteColumnAndColumnFamily")
public class deleteColumnAndColumnFamilyImpl implements deleteColumnAndColumnFamily {
    @Autowired
    HbaseConfig config;
    private static Connection connection = null;
    /**
     * 删除单行单列族单列记录
     *
     * @param tablename         表名
     * @param rowkey            行名
     * @param columnFamily      列族名
     * @param column            列名
     */
    @Override
    public void deleteColumn(String tablename, String rowkey, String columnFamily, String column) throws IOException {
        TableName name = TableName.valueOf(tablename);
        Table table = connection.getTable(name);
        Delete d = new Delete(rowkey.getBytes()).addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
        table.delete(d);
    }
    /**
     * 删除单行单列族记录
     * @param tablename         表名
     * @param rowkey            行名
     * @param columnFamily      列族名
     */
    @Override
    public void deleteColumnFamily(String tablename, String rowkey, String columnFamily) throws IOException {
        TableName name = TableName.valueOf(tablename);
        Table table = connection.getTable(name);
        Delete d = new Delete(rowkey.getBytes()).addFamily(Bytes.toBytes(columnFamily));
        table.delete(d);
    }
}
