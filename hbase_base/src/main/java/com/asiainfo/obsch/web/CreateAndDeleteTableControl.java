package com.asiainfo.obsch.web;


import com.asiainfo.obsch.service.CreateAndDeleteTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/table")
public class CreateAndDeleteTableControl {

    @Resource(name="CreateAndDeleteTable")
    CreateAndDeleteTable createAndDeleteTable;

    @RequestMapping("/createTable")
    public void createTable(String tablename, String[] columnFamily) throws IOException {
        createAndDeleteTable.createTable(tablename,columnFamily);
    }

    @RequestMapping("/deleteTable")
    public void deleteTable(String tablename) throws IOException {
        createAndDeleteTable.deleteTable(tablename);
    }

}
