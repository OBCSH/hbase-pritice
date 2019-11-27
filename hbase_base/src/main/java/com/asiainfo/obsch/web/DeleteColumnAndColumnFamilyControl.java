package com.asiainfo.obsch.web;

import com.asiainfo.obsch.service.DeleteColumnAndColumnFamily;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/Column")
public class DeleteColumnAndColumnFamilyControl {
    @Resource(name = "deleteColumnAndColumnFamily")
    DeleteColumnAndColumnFamily deleteColumnAndColumnFamily;
    @RequestMapping("/deleteColumn")
    public void deleteColumn(String tablename, String rowkey, String columnFamily, String column) throws IOException {
        deleteColumnAndColumnFamily.deleteColumn(tablename, rowkey, columnFamily, column);
    }
    @RequestMapping("/deleteColumnFamily")
    public void deleteColumnFamily(String tablename, String rowkey, String columnFamily) throws IOException {
        deleteColumnAndColumnFamily.deleteColumnFamily(tablename, rowkey, columnFamily);
    }
}
