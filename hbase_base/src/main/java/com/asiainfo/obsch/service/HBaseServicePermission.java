package com.asiainfo.obsch.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.security.access.Permission;

public interface HBaseServicePermission {
    /**
     * 授予用户权限
     *
     * @param userName 用户
     * @param actions  权限
     */
    void grant(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable;
    /**
     * 回收用户权限
     *
     * @param userName 用户
     * @param actions  权限
     */
    void revoke(Configuration configuration, String tableName, String userName, String family, String qual, Permission.Action... actions) throws Throwable;
}
