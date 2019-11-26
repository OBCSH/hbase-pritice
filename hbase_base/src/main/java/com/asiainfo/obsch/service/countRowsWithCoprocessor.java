package com.asiainfo.obsch.service;

public interface countRowsWithCoprocessor {
    /**
     * 利用协处理器进行全表count统计
     *
     * @param tablename
     */
    Long countRowsWithCoprocessor(String tablename) throws Throwable;
}
