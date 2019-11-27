package com.asiainfo.obsch.service;

import java.io.IOException;
import java.util.List;

public interface ScanReportDataByRowKeyword {
    /**
     * 根据rowkey关键字查询报告记录
     *
     * @param tablename
     * @param rowKeyword
     * @return
     */
    List scanReportDataByRowKeyword(String tablename, String rowKeyword) throws IOException;
    /**
     * 根据rowkey关键字和时间戳范围查询报告记录
     *
     * @param tablename
     * @param rowKeyword
     * @return
     */
    List scanReportDataByRowKeywordTimestamp(String tablename, String rowKeyword, Long minStamp, Long maxStamp) throws IOException;
}
