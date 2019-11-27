package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.createAndDeleteTable;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service("createAndDeleteTable")
public class createAndDeleteTableImpl implements createAndDeleteTable {
    @Autowired
    HbaseConfig config;
    private static Admin admin = null;
    /**
     * 创建表
     *
     * @param tableName         表名
     * @param columnFamily      列族（数组）
     */
    @Override
    public void createTable(String tableName, String[] columnFamily) throws IOException {
        TableName name = TableName.valueOf(tableName);
        //如果存在则删除
        if (admin.tableExists(name)) {
            admin.disableTable(name);
            admin.deleteTable(name);
            System.out.println("create htable error! this table {} already exists!"+name);
        } else {
            HTableDescriptor desc = new HTableDescriptor(name);
            for (String cf : columnFamily) {
                desc.addFamily(new HColumnDescriptor(cf));
            }
            admin.createTable(desc);
        }
    }


    /**
     * 删除表操作
     *
     * @param tablename
     */

    @Override
    public void deleteTable(String tablename) throws IOException {
        TableName name=TableName.valueOf(tablename);
        if(admin.tableExists(name)) {
            admin.disableTable(name);
            admin.deleteTable(name);
        }
    }
}
