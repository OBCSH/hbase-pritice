package com.asiainfo.obsch.Authorization;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.security.access.AccessControlClient;
import org.apache.hadoop.hbase.security.access.Permission;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;


public class HBaseServicePermission {
    private static final Logger logger = Logger.getLogger(String.valueOf(HBaseServicePermission.class));
    static Configuration configuration = null;
    /**
     * 授予用户权限
     *
     * @param userName 用户
     * @param actions  权限
     */
    public void grant(Configuration configuration, String tableName,String userName, String family,String qual,Permission.Action... actions) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("HBaseServiceImpl grant begin");
        }
        HTable table = new HTable(configuration, Bytes.toBytes(tableName));
        TableName tableName1 = table.getName();
        AccessControlClient.grant(configuration, tableName1, userName, Bytes.toBytes(family), Bytes.toBytes(qual), actions);
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
    public void revoke(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("HBaseServiceImpl revoke begin");
        }
        HTable table = new HTable(configuration, Bytes.toBytes(tableName));
        TableName tableName1 = table.getName();
        AccessControlClient.revoke(configuration, tableName1, userName, Bytes.toBytes(family), Bytes.toBytes(qual), actions);
        if (logger.isInfoEnabled()) {
            logger.info("HBaseServiceImpl revoke end");
        }
    }

}
