package com.asiainfo.obsch.service.impl;

import com.asiainfo.obsch.config.HbaseConfig;
import com.asiainfo.obsch.service.ScanReportDataByRowKeyword;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("scanReportDataByRowKeyword")
public class scanReportDataByRowKeywordImpl implements ScanReportDataByRowKeyword {
    @Autowired
    HbaseConfig config;
    private static Connection connection = null;
    /**
     * 根据rowkey关键字查询报告记录
     *
     * @param tablename
     * @param rowKeyword
     * @return
     */
    @Override
    public List scanReportDataByRowKeyword(String tablename, String rowKeyword) throws IOException {
        ArrayList<Object> list = new ArrayList<Object>();

        Table table = connection.getTable(TableName.valueOf(tablename));
        Scan scan = new Scan();

        //添加行键过滤器，根据关键字匹配
        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(rowKeyword));
        scan.setFilter(rowFilter);

        ResultScanner scanner = table.getScanner(scan);
        try {
            for (Result result : scanner) {

                list.add(null);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        scanner.close();
        return list;

    }
    /**
     * 根据rowkey关键字和时间戳范围查询报告记录
     *
     * @param tablename
     * @param rowKeyword
     * @return
     */
    @Override
    public List scanReportDataByRowKeywordTimestamp(String tablename, String rowKeyword, Long minStamp, Long maxStamp) throws IOException {
        ArrayList<Object> list = new ArrayList<Object>();

        Table table = connection.getTable(TableName.valueOf(tablename));
        Scan scan = new Scan();
        //添加scan的时间范围
        scan.setTimeRange(minStamp, maxStamp);

        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(rowKeyword));
        scan.setFilter(rowFilter);

        ResultScanner scanner = table.getScanner(scan);
        try {
            for (Result result : scanner) {

                list.add(null);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        scanner.close();
        return list;
    }
}
