package com.asiainfo.obsch.service;

public interface CountRowsWithCoprocessor {
    /**
     * 利用协处理器进行全表count统计
     *
     * @param tablename
     */
    Long countRowsWithCoprocessor(String tablename) throws Throwable;
}
