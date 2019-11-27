package com.asiainfo.obsch.web;

import com.asiainfo.obsch.service.SelectValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/Value")
public class SelectValueControl {
    @Resource(name = "selectValue")
    SelectValue selectValue;
    @RequestMapping("/selectValue")
   public String selectValue(String tablename, String rowKey, String columnFamily, String column) throws IOException {
        return selectValue.selectValue(tablename, rowKey, columnFamily, column);
    }
}
