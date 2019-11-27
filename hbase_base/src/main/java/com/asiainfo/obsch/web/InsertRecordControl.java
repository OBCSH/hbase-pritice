package com.asiainfo.obsch.web;

import com.asiainfo.obsch.service.InsertRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/Record")
public class InsertRecordControl {

    @Resource(name = "insertRecord")
    InsertRecord insertRecord;
    @RequestMapping("/insertOneRecord")
    public  void insertOneRecord(String tableName, String row, String columnFamily, String column, String value) throws IOException {
        insertRecord.insertOneRecord(tableName, row, columnFamily, column, value);
    }
    @RequestMapping("/insertRecords")
    public void insertRecords(String tableName, String row, String columnFamilys, String[] columns, String[] values) throws IOException {
        insertRecord.insertRecords(tableName, row, columnFamilys, columns, values);
    }

}
