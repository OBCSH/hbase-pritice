package com.asiainfo.obsch.Authorization;

import com.asiainfo.obsch.service.HBaseServicePermission;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.security.access.AccessControlClient;
import org.apache.hadoop.hbase.security.access.Permission;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;


public class HBaseServicePermissionImpl implements HBaseServicePermission {
    private static final Logger logger = Logger.getLogger(String.valueOf(HBaseServicePermission.class));

    private static Configuration conf = HBaseConfiguration.create();

    /**
     * 授予用户权限
     *
     * @param userName 用户
     * @param actions  权限
     */
    @Override
    public void grant(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("HBaseServiceImpl grant begin");
        }
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf(tableName));
        TableName tableName1 = table.getName();
        AccessControlClient.grant((Connection) configuration, tableName1, userName, Bytes.toBytes(family), Bytes.toBytes(qual), actions);
        if (logger.isInfoEnabled()) {
            logger.info("HBaseServiceImpl grant end");
        }
    }
    /**
     * 回收用户权限
     *
     * @param userName 用户
     * @param actions  权限
     */
    @Override
    public void revoke(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable {

            if (logger.isInfoEnabled()) {
                logger.info("HBaseServiceImpl revoke begin");
            }
            Connection connection = ConnectionFactory.createConnection(conf);
            Table table = connection.getTable(TableName.valueOf(tableName));
            TableName tableName1 = table.getName();
            AccessControlClient.revoke((Connection) configuration, tableName1, userName, Bytes.toBytes(family), Bytes.toBytes(qual), actions);
            if (logger.isInfoEnabled()) {
                logger.info("HBaseServiceImpl revoke end");
            }
    }
}
