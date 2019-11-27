package com.asiainfo.obsch.web;

import com.asiainfo.obsch.service.SelectAndDeleteRow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/Row")
public class SelectAndDeleteRowControl {
    @Resource(name = "selectAndDeleteRow")
    SelectAndDeleteRow selectAndDeleteRow;
    @RequestMapping("/selectRow")
    String selectRow(String tablename, String rowKey) throws IOException {
        return selectAndDeleteRow.selectRow(tablename, rowKey);
    }
    @RequestMapping("/deleteRow")
    void deleteRow(String tablename, String rowkey) throws IOException {
        selectAndDeleteRow.deleteRow(tablename, rowkey);
    }



}
