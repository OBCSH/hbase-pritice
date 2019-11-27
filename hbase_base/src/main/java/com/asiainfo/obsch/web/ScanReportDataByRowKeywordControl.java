package com.asiainfo.obsch.web;

import com.asiainfo.obsch.service.ScanReportDataByRowKeyword;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Report")
public class ScanReportDataByRowKeywordControl {
    @Resource(name = "scanReportDataByRowKeyword")
    ScanReportDataByRowKeyword scanReportDataByRowKeyword;
    @RequestMapping("/scanReportDataByRowKeyword")
    List scanReportDataByRowKeyword(String tablename, String rowKeyword) throws IOException {
        return scanReportDataByRowKeyword.scanReportDataByRowKeyword(tablename, rowKeyword);
    }
    @RequestMapping("/scanReportDataByRowKeywordTimestamp")
    List scanReportDataByRowKeywordTimestamp(String tablename, String rowKeyword, Long minStamp, Long maxStamp) throws IOException {
        return scanReportDataByRowKeyword.scanReportDataByRowKeywordTimestamp(tablename, rowKeyword, minStamp, maxStamp);
    }
}
