package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.selectValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;



@Service("selectValue")
public class selectValueImpl implements selectValue {
    @Autowired
    HbaseConfig config;

    private static Connection connection = null;
    /**
     * 查找单行单列族单列记录
     *
     * @param tablename         表名
     * @param rowKey            行名
     * @param columnFamily      列族名
     * @param column            列名
     * @return
     */
    @Override
    public String selectValue(String tablename, String rowKey, String columnFamily, String column) throws IOException {
        TableName name=TableName.valueOf(tablename);
        Table table = connection.getTable(name);
        Get g = new Get(rowKey.getBytes());
        g.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
        Result rs = table.get(g);
        return Bytes.toString(rs.value());

    }
}
