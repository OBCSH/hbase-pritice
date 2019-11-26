package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.selectAndDeleteRow;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.NavigableMap;

public class selectAndDeleteRowImpl implements selectAndDeleteRow {

    @Autowired
    HbaseConfig config;

    private static Connection connection = null;
    /**
     * 查找一行记录
     *
     * @param tablename         表名
     * @param rowKey            行名
     */
    @Override
    public String selectRow(String tablename, String rowKey) throws IOException {
        String record = "";
        TableName name=TableName.valueOf(tablename);
        Table table = connection.getTable(name);
        Get g = new Get(rowKey.getBytes());
        Result rs = table.get(g);
        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = rs.getMap();
        for (Cell cell : rs.rawCells()) {
            StringBuffer stringBuffer = new StringBuffer()
                    .append(Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength())).append("\t")
                    .append(Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength())).append("\t")
                    .append(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength())).append("\t")
                    .append(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength())).append("\n");
            String str = stringBuffer.toString();
            record += str;
        }
        return record;
    }
    /**
     * 删除一行记录
     *
     * @param tablename         表名
     * @param rowkey            行名
     */
    @Override
    public void deleteRow(String tablename, String rowkey) throws IOException {
        TableName name = TableName.valueOf(tablename);
        Table table = connection.getTable(name);
        Delete d = new Delete(rowkey.getBytes());
        table.delete(d);
    }
}
